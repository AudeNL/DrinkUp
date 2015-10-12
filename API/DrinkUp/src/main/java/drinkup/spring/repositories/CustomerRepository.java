package drinkup.spring.repositories;

import drinkup.spring.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
