package Data;

import Model.Ingredient;
import Model.RecipeCategory;
import Query.QueryRecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDao extends QueryRecipeCategory {
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory findById(Integer recipeCategoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory update(RecipeCategory recipeCategoryId);
    boolean delete(Integer recipeCategoryId);
}
