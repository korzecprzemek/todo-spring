package pl.pkorzec.model;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TaskService {
    private TaskList taskList = new TaskList();

    public void addTask(String taskName, LocalTime taskStartTime, LocalTime taskEndTime){
        taskList.addTask(taskName,taskStartTime,taskEndTime);
    }
    public void addTask(Task task){
        taskList.addTask(task);
    }

    public List<Task> getAll() {
        return taskList.getTaskList();
    }
    public void print(){
        taskList.print();
    }
}
