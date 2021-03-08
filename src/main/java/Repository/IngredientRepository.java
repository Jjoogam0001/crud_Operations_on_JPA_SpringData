package Repository;

import Data.IngredientDao;
import Model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


import java.util.Collection;

@Repository

public class IngredientRepository implements IngredientDao {

    private final EntityManager em;

    @Autowired
    public IngredientRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient create(Ingredient ingredient) {
        em.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredient findById(Integer ingredientid) {
        return em.find(Ingredient.class,ingredientid);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Ingredient> findAll() {
        return em
                .createQuery("SELECT ingredients FROM Ingredient ingredients", Ingredient.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient update(Ingredient ingredient) {
        return em.merge(ingredient);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(Integer ingredientid) {
        Ingredient toRemove = findById(ingredientid);
        if(toRemove != null){
            em.remove(toRemove);

        }else {
            throw new IllegalArgumentException("Ingredient could not be found");
        }
        toRemove = findById(ingredientid);
        return toRemove == null;
    }

    @Override

    public Collection<Ingredient> findByIngredientBYname(String name) {
        return em
                .createQuery("SELECT s FROM Ingredient s WHERE UPPER(s.ingredientName) = UPPER(?1)", Ingredient.class)
                .setParameter(1, name)
                .getResultList();
    }
}
