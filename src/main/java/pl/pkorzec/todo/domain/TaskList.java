package pl.pkorzec.todo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Optional<Task> findById(Long id){
        return taskList.stream()
                .filter(t -> Objects.equals(t.getId(),id))
                .findFirst();
            }

    public boolean removeById(Long id){
        return taskList.removeIf(t -> Objects.equals(t.getId(), id));

    }
    public boolean toggleById(Long id){
        Optional<Task> opt = findById(id);
        opt.ifPresent(t -> t.setDone(!t.isDone()));
        return opt.isPresent();
    }
    public void addTask(Task task) {
        this.taskList.add(task);

    }
    public List<Task> getTaskList(){
        return taskList;
    }
}
