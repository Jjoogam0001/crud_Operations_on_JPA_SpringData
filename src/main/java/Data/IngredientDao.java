package Data;

import Model.Ingredient;
import Query.QueryIngredient;

import java.util.Collection;

public interface IngredientDao extends QueryIngredient {
    Ingredient create(Ingredient ingredient);
    Ingredient findById(Integer ingredientid);
    Collection<Ingredient> findAll();
    Ingredient update(Ingredient ingredient);
    boolean delete(Integer ingredientid);
}
