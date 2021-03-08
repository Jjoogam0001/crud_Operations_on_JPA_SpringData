package Data;

import Model.RecipeIngredient;
import Query.QueryRecipeIngredients;

import java.util.Collection;

public interface RecipeIngredientDao extends QueryRecipeIngredients {

    RecipeIngredient create(RecipeIngredient recipeIngredient);
    RecipeIngredient findById(Integer recipeIngredientId);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    boolean delete(Integer recipeIngredientId);
}
