package Model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "recipe_category")
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int categoryId;
    @Column(length = 255)
    private String categoryName;
    @ManyToMany
    private List<Recipe> recipeList;

    public RecipeCategory() {
    }

    public RecipeCategory(int categoryId, String categoryName, List<Recipe> recipeList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.recipeList = recipeList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", recipeList=" + recipeList +
                '}';
    }
}
