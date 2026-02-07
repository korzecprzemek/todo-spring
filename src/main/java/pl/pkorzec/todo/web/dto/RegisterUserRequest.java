package pl.pkorzec.todo.web.dto;

public record RegisterUserRequest(
        String username,
        String password
) {}
