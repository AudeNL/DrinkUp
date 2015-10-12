package drinkup.spring.repositories;

import drinkup.spring.domain.OrderHistory;
import org.springframework.data.repository.CrudRepository;

public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Integer>{
}
