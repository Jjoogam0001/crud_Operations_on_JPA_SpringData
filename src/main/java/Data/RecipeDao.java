package Data;

import Model.Recipe;
import Query.QueryRecipe;

import java.util.Collection;

public interface RecipeDao extends QueryRecipe {
    Recipe create(Recipe recipe);
    Recipe findById(Integer recipeId);
    Collection<Recipe> findAll();
    Recipe update(Recipe recipe);
    boolean delete(Integer recipeId);
}
