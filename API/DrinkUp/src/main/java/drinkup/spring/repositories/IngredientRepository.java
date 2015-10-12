package drinkup.spring.repositories;

import drinkup.spring.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{
}
