package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String userName);
}
