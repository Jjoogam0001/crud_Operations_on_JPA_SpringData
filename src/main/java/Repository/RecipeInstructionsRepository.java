package Repository;

import Data.RecipeInstructionDao;
import Model.RecipeIngredient;
import Model.RecipeInstructions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository

public class RecipeInstructionsRepository implements RecipeInstructionDao {


    private final EntityManager em;
    @Autowired
    public RecipeInstructionsRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructions create(RecipeInstructions recipeInstructions) {
        em.persist(recipeInstructions);
        return recipeInstructions;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeInstructions findById(Integer recipeInstructionId) {
        return em.find(RecipeInstructions.class,recipeInstructionId);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeInstructions> findAll() {
        return  em
                .createQuery("SELECT recipeInstruction FROM RecipeInstructions recipeInstruction", RecipeInstructions.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructions update(RecipeInstructions recipeInstructions) {
        return em.merge(recipeInstructions);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer recipeInstructionId) {
        RecipeInstructions toRemove = findById(recipeInstructionId);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("recipe instruction could not be found");
        }
        toRemove = findById(recipeInstructionId);
        return toRemove == null;
    }

    @Override
    public Collection<RecipeInstructions> findRecipeInstructionsByName(String name) {
        return  em
                .createQuery("SELECT s FROM RecipeInstructions s WHERE UPPER(s.recipeInstructions) = UPPER(?1)", RecipeInstructions.class)
                .setParameter(1, name)
                .getResultList();
    }
}
