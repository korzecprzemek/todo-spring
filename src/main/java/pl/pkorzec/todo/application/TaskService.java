package pl.pkorzec.todo.application;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.pkorzec.todo.domain.*;
import pl.pkorzec.todo.web.dto.TaskFormDTO;
import pl.pkorzec.todo.persistence.TaskRepository;
import pl.pkorzec.todo.persistence.UserRepository;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class TaskService {
    /// /    private final TaskList taskList = new TaskList();
//    private final AtomicLong nextId = new AtomicLong(1);
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    private String currentUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    private User currentUser() {
        return userRepository.findByUsername(currentUsername())
                .orElseThrow(() -> new IllegalStateException("Current user not found in DB"));
    }
    public Task addTask(Task task) {
        task.setOwner(currentUser());

        if (task.getCreatedAt() == null) {
            task.setCreatedAt(LocalDateTime.now());
        }
        if (task.getPriority() == null) {
            task.setPriority(Priority.MEDIUM);
        }
        return taskRepository.save(task);
    }
    public Task addFromForm(TaskFormDTO dto) {
        Task task = new Task(
                dto.taskName(),
                dto.priority(),
                false,
                null
        );
        return addTask(task);
    }
    public void toggleDone(Long id) {
        Task task = findById(id);
        task.setDone(!task.isDone());
        taskRepository.save(task);
    }
    public List<Task> getAll() {
        return taskRepository.findAllByOwnerUsername(currentUsername());
    }
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
    public void removeById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
    public List<Task> findTasks(TaskQuery query) {
        List<Task> tasks = taskRepository.findAllByOwnerUsername(currentUsername());

        if (query.getDone() != null) {
            tasks = tasks.stream()
                    .filter(task -> task.isDone() == query.getDone())
                    .toList();
        }

        if (query.getPriority() != null) {
            tasks = tasks.stream()
                    .filter(task -> task.getPriority() == query.getPriority())
                    .toList();
        }

        if (query.getSearch() != null && !query.getSearch().isBlank()) {
            String searchLower = query.getSearch().toLowerCase();
            tasks = tasks.stream()
                    .filter(task -> task.getTaskName().toLowerCase().contains(searchLower))
                    .toList();
        }

        return tasks;
    }

}
