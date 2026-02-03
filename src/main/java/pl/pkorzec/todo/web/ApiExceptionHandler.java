package pl.pkorzec.todo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.pkorzec.todo.domain.TaskNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    public ApiError handleTaskNotFound(TaskNotFoundException ex){
        return new ApiError(404, ex.getMessage());
    }
    public record ApiError(int status, String message) {}


}
