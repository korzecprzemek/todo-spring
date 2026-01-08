package pl.pkorzec.model;

import java.time.LocalTime;

public class Task {
    private String taskName;
    private LocalTime taskStartTime;
    private LocalTime taskEndTime;

    public Task(String taskName, LocalTime taskStartTime, LocalTime taskEndTime){
        this.taskName = taskName;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
    }
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public LocalTime getTaskStartTime() {
        return taskStartTime;
    }
    public void setTaskStartTime(LocalTime taskStartTime) {
        this.taskStartTime = taskStartTime;
    }
    public LocalTime getTaskEndTime() {
        return taskEndTime;
    }
    public void setTaskEndTime(LocalTime taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public void updateTask(String taskName, LocalTime taskStartTime, LocalTime taskEndTime){
        setTaskName(taskName);
        setTaskStartTime(taskStartTime);
        setTaskEndTime(taskEndTime);
    }
    public String markTaskDone(){
    return "Task Done!";
    }
}
