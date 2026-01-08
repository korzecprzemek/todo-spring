package pl.pkorzec.model;

public record TaskFormDTO(
        String taskName,
        String taskStartTime,
        String taskEndTime
) {}

