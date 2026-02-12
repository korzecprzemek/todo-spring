package pl.pkorzec.todo.domain;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private boolean done;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User owner;
    private Long taskListId;

    protected Task(){ };
    public Task(Long id, String taskName, Priority priority, boolean isDone, LocalDateTime createdAt) {
        this.id = id;
        this.taskName = taskName;
        this.createdAt = createdAt;
        this.priority = priority;
        this.done = isDone;
    }
    public Task(String taskName, Priority priority, boolean isDone, LocalDateTime createdAt) {
        this.taskName = taskName;
        this.createdAt = createdAt;
        this.priority = priority;
        this.done = isDone;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    /**
     * TODO
     * @param taskName
     */
    public void updateTask(String taskName){
        setTaskName(taskName);
    }

    /**
     * TODO
     * @return
     */
    public String markTaskDone(){
    return "Task Done!";
    }
}
