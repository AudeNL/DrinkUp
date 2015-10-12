package drinkup.spring.repositories;

import drinkup.spring.domain.ProductIngredient;
import org.springframework.data.repository.CrudRepository;

public interface ProductIngredientRepository extends CrudRepository<ProductIngredient, Integer>{
}
