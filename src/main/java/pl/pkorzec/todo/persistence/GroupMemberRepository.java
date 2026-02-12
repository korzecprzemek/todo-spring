package pl.pkorzec.todo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pkorzec.todo.domain.GroupMember;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Long> {
}
