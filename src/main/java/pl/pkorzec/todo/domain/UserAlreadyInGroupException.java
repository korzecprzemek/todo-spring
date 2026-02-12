package pl.pkorzec.todo.domain;

public class UserAlreadyInGroupException extends RuntimeException {
    public UserAlreadyInGroupException(Long groupId, Long userId) {
        super("User with the id: " + userId + "is already in group: " + groupId);
    }
}
