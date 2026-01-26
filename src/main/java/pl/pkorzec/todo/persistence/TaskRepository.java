package pl.pkorzec.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
