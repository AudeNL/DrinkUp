package drinkup.spring.repositories;

import drinkup.spring.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer>{
}
