package pl.pkorzec.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList= new ArrayList<>();

    public TaskList(){
    }
    public void print(){
        for(Task task : taskList){
            System.out.println(task.getTaskName());
            System.out.println(task.getTaskStartTime());
            System.out.println(task.getTaskEndTime());
        }
    }
    public void addTask(String taskName,LocalTime taskStartTime, LocalTime taskEndTime){
        Task task = new Task(taskName,taskStartTime,taskEndTime);
        this.taskList.add(task);
    }
    public void addTask(Task task){
        this.taskList.add(task);
    }
    public Boolean removeTask(Task task){
        return this.taskList.remove(task);
    }
    public List<Task> getTaskList(){
        return taskList;
    }
}
