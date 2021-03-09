package Repository;


import Enums.Measurement;
import Model.Ingredient;
import Model.Recipe;
import Model.RecipeIngredient;
import Model.RecipeInstructions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;






class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;




    @Test

    void create() {
      /*  Ingredient ingds = new Ingredient(1,"Curry");
        RecipeInstructions rInst = new RecipeInstructions(1,"COOK MEAT AMD STEAM IT");
        List<RecipeIngredient> ings = Arrays.asList(new RecipeIngredient(1,ingds,100, Measurement.KG));
        Recipe recipe = new Recipe(1,"MatookeRecept",ings,rInst);


        Ingredient ingds2 = new Ingredient(1,"Curry");
        RecipeInstructions rInst2 = new RecipeInstructions(1,"COOK MEAT AMD STEAM IT");
        List<RecipeIngredient> ings2 = Arrays.asList(new RecipeIngredient(1,ingds2,100, Measurement.KG));
        Recipe recipe2 = new Recipe(1,"MatookeRecept",ings2,rInst2);
        assertNotNull(recipe);
        assertEquals(recipe2.getRecipeName(), recipe.getRecipeId());
        assertEquals(recipe2.getRecipeId(), recipe.getRecipeName());*/



    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByRecipeBYname() {
    }
}