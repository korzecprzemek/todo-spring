package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.TaskList;

import java.util.Optional;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {

    Optional<TaskList> findByOwnerUserId(Long id);
    Optional<TaskList> findByOwnerUserIdAndName(Long userId, String name);
}
