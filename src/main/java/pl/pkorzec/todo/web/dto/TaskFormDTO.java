package pl.pkorzec.todo.web.dto;


import pl.pkorzec.todo.domain.Priority;

public record TaskFormDTO(
        String taskName,
        Priority priority
) {}

