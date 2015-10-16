package drinkup.spring.repositories;

import drinkup.spring.domain.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer>{
}
