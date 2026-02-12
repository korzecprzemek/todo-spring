package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.GroupMember;
import pl.pkorzec.todo.domain.Role;

import java.util.Optional;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Long> {
    boolean existsByGroupIdAndUserIdAndRole(Long groupId, Long userId, Role role);
    boolean existsByGroupIdAndUserId(Long groupId, Long userId);
}
