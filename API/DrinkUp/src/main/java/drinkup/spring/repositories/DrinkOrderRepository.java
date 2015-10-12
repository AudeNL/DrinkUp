package drinkup.spring.repositories;

import drinkup.spring.domain.DrinkOrder;
import org.springframework.data.repository.CrudRepository;

public interface DrinkOrderRepository extends CrudRepository<DrinkOrder, Integer>{
}
