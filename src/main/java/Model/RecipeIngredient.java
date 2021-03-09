package Model;

import Enums.Measurement;


import javax.persistence.*;

@Entity
@Table(name ="recipe_ingredient")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int recipeIngredientId;
    @ManyToOne
    private Ingredient ingredient;
    @Column(length = 100)
    private double amount;

    private Measurement measurement;
    @ManyToOne
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(int recipeIngredientId, Ingredient ingredient, double amount, Measurement measurement) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    /**
     * get field
     *
     * @return recipeIngredientId
     */
    public int getRecipeIngredientId() {
        return this.recipeIngredientId;
    }

    /**
     * set field
     *
     * @param recipeIngredientId
     */
    public void setRecipeIngredientId(int recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    /**
     * get field
     *
     * @return ingredient
     */
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    /**
     * set field
     *
     * @param ingredient
     */
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * get field
     *
     * @return amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * set field
     *
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * get field
     *
     * @return measurement
     */
    public Measurement getMeasurement() {
        return this.measurement;
    }

    /**
     * set field
     *
     * @param measurement
     */
    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    /**
     * get field
     *
     * @return recipe
     */
    public Recipe getRecipe() {
        return this.recipe;
    }

    /**
     * set field
     *
     * @param recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
