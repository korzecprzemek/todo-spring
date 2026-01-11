package pl.pkorzec.todo.web;


import pl.pkorzec.todo.domain.Priority;

public record TaskFormDTO(
        String taskName,
        Priority priority
) {}

