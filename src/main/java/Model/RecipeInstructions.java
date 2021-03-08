package Model;

import javax.persistence.*;

@Entity
@Table(name = "recipe_instructions")
public class RecipeInstructions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int RecipeInstructionsId;
    @Column(length = 2000)
    private String recipeInstructions;

    public RecipeInstructions() {
    }

    public RecipeInstructions(int recipeInstructionsId, String recipeInstructions) {
        RecipeInstructionsId = recipeInstructionsId;
        this.recipeInstructions = recipeInstructions;
    }


    /**
     * get field
     *
     * @return RecipeInstructionsId
     */
    public int getRecipeInstructionsId() {
        return this.RecipeInstructionsId;
    }

    /**
     * set field
     *
     * @param RecipeInstructionsId
     */
    public void setRecipeInstructionsId(int RecipeInstructionsId) {
        this.RecipeInstructionsId = RecipeInstructionsId;
    }

    /**
     * get field
     *
     * @return recipeInstructions
     */
    public String getRecipeInstructions() {
        return this.recipeInstructions;
    }

    /**
     * set field
     *
     * @param recipeInstructions
     */
    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public String toString() {
        return "RecipeInstructions{" +
                "RecipeInstructionsId=" + RecipeInstructionsId +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
