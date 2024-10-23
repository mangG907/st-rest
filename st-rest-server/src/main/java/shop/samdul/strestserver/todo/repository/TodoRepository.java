package shop.samdul.strestserver.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.samdul.strestserver.todo.entity.TodoEntity;

public interface TodoRepository  extends JpaRepository <TodoEntity, Integer>{
}
