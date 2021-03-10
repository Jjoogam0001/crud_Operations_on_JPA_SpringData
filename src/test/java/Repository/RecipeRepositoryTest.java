package Repository;


import Data.RecipeDao;
import Enums.Measurement;
import Model.Ingredient;
import Model.Recipe;
import Model.RecipeIngredient;
import Model.RecipeInstructions;
import crud.example.crud_demo.CrudDemoApplication;
import crud.example.crud_demo.CrudDemoApplicationTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@EnableAutoConfiguration
@Transactional
@DirtiesContext


@SpringBootTest(classes = CrudDemoApplicationTests.class)
@EnableJpaRepositories(basePackageClasses = RecipeRepository.class)
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository testObject;

    @Autowired
    private TestEntityManager em;


    private Recipe persistentRecipe;


    @BeforeEach
    void setUp() {
        Ingredient ingds = new Ingredient(1, "Curry");
        RecipeInstructions rInst = new RecipeInstructions(1, "COOK MEAT AMD STEAM IT");
        List<RecipeIngredient> ings = Arrays.asList(new RecipeIngredient(1, ingds, 100, Measurement.KG));
        Recipe unPersisted = new Recipe(1, "Spaghetti_Recept", ings, rInst);
        persistentRecipe = em.persistAndFlush(unPersisted);


    }


    @AfterEach
    void tearDown() {
        em.flush();
    }


    @Test
    void create() {
        Ingredient ingds2 = new Ingredient(1, "Curry");
        RecipeInstructions rInst2 = new RecipeInstructions(1, "COOK MEAT AMD STEAM IT");
        List<RecipeIngredient> ings2 = Arrays.asList(new RecipeIngredient(1, ingds2, 100, Measurement.KG));
        Recipe recipe2 = new Recipe(1, "MatookeRecept", ings2, rInst2);
        Recipe result = testObject.create(recipe2);
        assertNotNull(result);
        assertNotNull(result.getRecipeId());


    }

    @Test
    void findById() {

        Integer receptId = persistentRecipe.getRecipeId();
        Recipe result = testObject.findById(receptId);
        assertNotNull(result);
        assertEquals(persistentRecipe, result);
    }

    @Test
    void findAll() {

        int expected = 1;
        Collection<Recipe> result = testObject.findAll();
        assertNotNull(result);
        assertEquals(expected, result.size());


    }

    @Test
    void update() {
        Recipe toUpdate = persistentRecipe;
        toUpdate.setRecipeName("Broccoli");

        Recipe result = testObject.update(toUpdate);

        assertNotNull(result);
        assertEquals("Broccoli", result.getRecipeName());
    }

    @Test
    void delete() {
        assertTrue(testObject.delete(persistentRecipe.getRecipeId()));
    }

    @Test
    void findByRecipeBYname() {
        String RecipeName = "Broccoli";

        Collection<Recipe> result = testObject.findByRecipeBYname(RecipeName);

        assertNotNull(result);
        assertEquals(1, result.size());


    }
}