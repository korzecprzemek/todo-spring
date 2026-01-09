package pl.pkorzec.model;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;

@Service
public class TaskService {
    private final TaskList taskList = new TaskList();
    private final AtomicLong nextId = new AtomicLong(1);

    public Task addTask(Task task){
        task.setId(nextId.getAndIncrement());
        if(task.getCreatedAt() == null){
            task.setCreatedAt(LocalDateTime.now());
        }
        if(task.getPriority() == null){
            task.setPriority(Priority.MEDIUM);
        }
        taskList.addTask(task);
        return task;
    }
    public Task addFromForm(TaskFormDTO dto){
        Task task = new Task(
                dto.taskName(),
                dto.priority(),
                false,
                null
        );
        return addTask(task);
    }

    public List<Task> getAll() {
        return taskList.getTaskList();
    }
    public void print(){
        taskList.print();
    }
    public Task findById(Long id){
        return taskList.findById(id);
    }
    public void removeById(Long id){
        taskList.removeById(id);
    }
}
