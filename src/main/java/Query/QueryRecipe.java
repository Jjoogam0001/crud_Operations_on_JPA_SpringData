package Query;

import Model.Recipe;

import java.util.Collection;

public interface QueryRecipe {
    Collection<Recipe> findByRecipeBYname(String name);
}
