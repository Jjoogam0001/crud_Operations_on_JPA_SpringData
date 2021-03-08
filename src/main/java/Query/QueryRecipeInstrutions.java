package Query;

import Model.RecipeInstructions;

import java.util.Collection;

public interface QueryRecipeInstrutions {
    Collection<RecipeInstructions> findRecipeInstructionsByName(String name);
}
