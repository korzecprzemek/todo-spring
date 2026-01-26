package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
