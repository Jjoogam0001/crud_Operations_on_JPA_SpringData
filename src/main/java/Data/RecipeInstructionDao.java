package Data;

import Model.RecipeInstructions;
import Query.QueryRecipeInstrutions;

import java.util.Collection;

public interface RecipeInstructionDao extends QueryRecipeInstrutions {

    RecipeInstructions create(RecipeInstructions recipeInstructions);
    RecipeInstructions findById(Integer recipeInstructionId);
    Collection<RecipeInstructions> findAll();
    RecipeInstructions update(RecipeInstructions recipeInstructions);
    boolean delete(Integer recipeInstructionId);
}
