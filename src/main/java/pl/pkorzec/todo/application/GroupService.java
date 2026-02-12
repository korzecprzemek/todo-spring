package pl.pkorzec.todo.application;

import org.springframework.stereotype.Service;
import pl.pkorzec.todo.domain.*;
import pl.pkorzec.todo.persistence.GroupMemberRepository;
import pl.pkorzec.todo.persistence.GroupRepository;

import java.time.LocalDateTime;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private GroupMemberRepository groupMemberRepository;
    private final UserAuthService userAuthService;

    public GroupService(GroupRepository groupRepository, UserAuthService userAuthService){
        this.groupRepository = groupRepository;
        this.userAuthService = userAuthService;
    }
    public Group createGroup(String name){
        User currentUser = userAuthService.currentUser();
        Group group = new Group(name);
        groupRepository.save(group);

        GroupMember member = new GroupMember(
                currentUser.getId(),
                group.getId(),
                Role.OWNER,
                LocalDateTime.now()
        );
        groupMemberRepository.save(member);
        return group;
    }
    public void addMember(Long groupId, Long newUserId){
        User currentUser = userAuthService.currentUser();
        if(!groupMemberRepository.existsByGroupIdAndUserIdAndRole(groupId,currentUser.getId(), Role.OWNER)){
            throw new NoPermissionException(groupId, currentUser.getId());
        }
        if(groupMemberRepository.existsByGroupIdAndUserId(groupId,newUserId)){
            throw new UserAlreadyInGroupException(groupId, newUserId);
        }
        GroupMember member = new GroupMember(
                newUserId,
                groupId,
                Role.MEMBER,
                LocalDateTime.now()
        );
        groupMemberRepository.save(member);
    }
}
