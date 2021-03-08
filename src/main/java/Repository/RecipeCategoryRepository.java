package Repository;

import Data.RecipeCategoryDao;
import Model.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository

public class RecipeCategoryRepository implements RecipeCategoryDao {

    private final EntityManager em;

    @Autowired
    public RecipeCategoryRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory create(RecipeCategory recipeCategory) {
        em.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeCategory findById(Integer recipeCategoryId) {
        return em.find(RecipeCategory.class,recipeCategoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeCategory> findAll() {
        return em.createQuery("SELECT recipeCategory from RecipeCategory recipeCategory",RecipeCategory.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory update(RecipeCategory recipeCategoryId) {
        return em.merge(recipeCategoryId);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer recipeCategoryId) {
        RecipeCategory toRemove = findById(recipeCategoryId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("Recipe Category could not be found");
        }
        toRemove = findById(recipeCategoryId);
        return toRemove == null;

    }

    @Override
    public Collection<RecipeCategory> findRecipeCategoriesByCategory(String name) {
        return em
                .createQuery("SELECT s FROM RecipeCategory s WHERE UPPER(s.categoryName) = UPPER(?1)", RecipeCategory.class)
                .setParameter(1, name)
                .getResultList();
    }
}
