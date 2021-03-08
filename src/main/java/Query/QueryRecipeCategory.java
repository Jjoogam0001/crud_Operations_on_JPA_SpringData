package Query;

import Model.RecipeCategory;

import java.util.Collection;

public interface QueryRecipeCategory {
    Collection<RecipeCategory> findRecipeCategoriesByCategory(String name);
}
