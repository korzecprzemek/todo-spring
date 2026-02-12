package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
