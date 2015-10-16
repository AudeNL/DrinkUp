package drinkup.spring.repositories;

import drinkup.spring.domain.Pub;
import org.springframework.data.repository.CrudRepository;

public interface PubRepository extends CrudRepository<Pub, Integer>{
}
