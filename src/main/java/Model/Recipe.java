package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int recipeId;
    @Column(length = 255)
    private String recipeName;
    @OneToMany
    public  List<RecipeIngredient> recipeIngredients;
    @OneToOne
    public RecipeInstructions recipeInstructions;
    @ManyToMany
    private List<RecipeCategory> recipeCategories;

    public Recipe() {
    }

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstructions recipeInstructions, List<RecipeCategory> recipeCategories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.recipeCategories = recipeCategories;
    }


    /**
     * get field
     *
     * @return recipeId
     */
    public int getRecipeId() {
        return this.recipeId;
    }

    /**
     * set field
     *
     * @param recipeId
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * get field
     *
     * @return recipeName
     */
    public String getRecipeName() {
        return this.recipeName;
    }

    /**
     * set field
     *
     * @param recipeName
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * get field
     *
     * @return recipeIngredients
     */
    public List<RecipeIngredient> getRecipeIngredients() {
        return this.recipeIngredients;
    }

    /**
     * set field
     *
     * @param recipeIngredients
     */
    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * get field
     *
     * @return recipeInstructions
     */
    public RecipeInstructions getRecipeInstructions() {
        return this.recipeInstructions;
    }

    /**
     * set field
     *
     * @param recipeInstructions
     */
    public void setRecipeInstructions(RecipeInstructions recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    /**
     * get field
     *
     * @return recipeCategories
     */
    public List<RecipeCategory> getRecipeCategories() {
        return this.recipeCategories;
    }

    /**
     * set field
     *
     * @param recipeCategories
     */
    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstructions=" + recipeInstructions +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
