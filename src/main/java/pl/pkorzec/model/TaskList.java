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
            System.out.println(task.getPriority());
        }
    }
    public Task findById(Long id){
        for(Task task : this.taskList) {
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }
    public void removeById(Long id){
        Task task = findById(id);
        this.taskList.remove(task);
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
