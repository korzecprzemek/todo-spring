package pl.pkorzec.todo.domain;

public class NoPermissionException extends RuntimeException {
    public NoPermissionException(Long groupId, Long userId) {
        super("User with the id: " + userId  + "does not have required permission in group: " + groupId);
    }
}
