package crud.example.crud_demo;

import Repository.RecipeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudDemoApplication.class, args);

    }

}
