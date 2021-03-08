package Query;

import Model.Ingredient;

import java.util.Collection;

public interface QueryIngredient {
    Collection<Ingredient> findByIngredientBYname(String name);
}
