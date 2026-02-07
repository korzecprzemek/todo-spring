package pl.pkorzec.todo.web.dto;

public record LoginRequest(
        String username,
        String password
) {}
