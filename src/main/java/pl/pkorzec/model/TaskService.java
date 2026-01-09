package pl.pkorzec.model;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final TaskList taskList = new TaskList();
    private final AtomicLong nextId = new AtomicLong(1);

    public void addTask(String taskName, LocalTime taskStartTime, LocalTime taskEndTime){
        long id = this.nextId.getAndIncrement();
        Task task = new Task(id,taskName,taskStartTime,taskEndTime);

        taskList.addTask(task);
    }
    public void addTask(Task task){
        long id = nextId.getAndIncrement();
        Task withId = new Task(id, task.getTaskName(),task.getTaskStartTime(),task.getTaskEndTime());
        taskList.addTask(withId);
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
