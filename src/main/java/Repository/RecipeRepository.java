package Repository;

import Data.RecipeDao;
import Model.Recipe;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.Collection;

@Repository

public class RecipeRepository implements RecipeDao {

    @PersistenceUnit
    private final EntityManager em;

    @Autowired
    public RecipeRepository(EntityManager em) {
        this.em = em;
    }



    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe create(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional(readOnly = true)
    public Recipe findById(Integer recipeId) {
        return em.find(Recipe.class,recipeId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Recipe> findAll() {
        return  em
                .createQuery("SELECT recipe FROM Recipe recipe", Recipe.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe update(Recipe recipe) {
        return em.merge(recipe);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer recipeId) {
        Recipe toRemove = findById(recipeId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("recipe instruction could not be found");
        }
        toRemove = findById(recipeId);
        return toRemove == null;
    }

    @Override
    public Collection<Recipe> findByRecipeBYname(String name) {
        return em
                .createQuery("SELECT s FROM Recipe s WHERE UPPER(s.recipeName) = UPPER(?1)", Recipe.class)
                .setParameter(1, name)
                .getResultList();
    }

}
