package pl.pkorzec.todo.web;

import org.springframework.web.bind.annotation.*;

import pl.pkorzec.todo.application.TaskQuery;
import pl.pkorzec.todo.application.TaskService;
import pl.pkorzec.todo.domain.Task;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(TaskQuery query){
        return taskService.findTasks(query);
    }
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.removeById(id);
    }
    @PatchMapping("/{id}/toggle")
    public void toggle(@PathVariable Long id){
        taskService.toggleDone(id);
    }
}
