package pl.pkorzec.todo.application;

import org.springframework.stereotype.Service;
import pl.pkorzec.todo.domain.*;
import pl.pkorzec.todo.web.TaskFormDTO;
import pl.pkorzec.todo.persistence.TaskRepository;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class TaskService {
    /// /    private final TaskList taskList = new TaskList();
//    private final AtomicLong nextId = new AtomicLong(1);
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
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
        return taskRepository.findAll();
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
}
