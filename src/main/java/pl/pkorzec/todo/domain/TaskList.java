package pl.pkorzec.todo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "task_lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long ownerUserId;
    private Long ownerGroupId;

    public TaskList(){};
    public TaskList(Long id, String name, Long ownerUserId, Long ownerGroupId) {
        this.id = id;
        this.name = name;
        this.ownerUserId = ownerUserId;
        this.ownerGroupId = ownerGroupId;
    }

    public TaskList(String name, Long ownerUserId, Long ownerGroupId) {
        this.name = name;
        this.ownerUserId = ownerUserId;
        this.ownerGroupId = ownerGroupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerGroupId() {
        return ownerGroupId;
    }

    public void setOwnerGroupId(Long ownerGroupId) {
        this.ownerGroupId = ownerGroupId;
    }
}
