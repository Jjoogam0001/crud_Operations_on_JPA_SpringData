package Query;

import Model.Recipe;
import Model.RecipeIngredient;

import java.util.Collection;

public interface QueryRecipeIngredients {
    Collection<RecipeIngredient> findRecipeIngredientsByName(String name);
}
