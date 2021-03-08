package Repository;

import Data.RecipeIngredientDao;
import Model.Recipe;
import Model.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository

public class RecipeIngredientRepository implements RecipeIngredientDao {

    private final EntityManager em;

    @Autowired
    public RecipeIngredientRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        em.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeIngredient findById(Integer recipeIngredientId) {
        return em.find(RecipeIngredient.class,recipeIngredientId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeIngredient> findAll() {
        return  em
                .createQuery("SELECT recipeIngredient FROM RecipeIngredient recipeIngredient", RecipeIngredient.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return em.merge(recipeIngredient);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer recipeIngredientId) {
        RecipeIngredient toRemove = findById(recipeIngredientId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("recipe Ingredient could not be found");
        }
        toRemove = findById(recipeIngredientId);
        return toRemove == null;
    }

    @Override
    public Collection<RecipeIngredient> findRecipeIngredientsByName(String name) {
        return em
                .createQuery("SELECT s FROM RecipeIngredient s WHERE UPPER(s.ingredient) = UPPER(?1)", RecipeIngredient.class)
                .setParameter(1, name)
                .getResultList();
    }
}
