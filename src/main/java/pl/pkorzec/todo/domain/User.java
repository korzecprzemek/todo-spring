package pl.pkorzec.todo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 50
    )
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(name = "password_hash",nullable = false)
    private String passwordHash;

    protected User() {};
    public User(Long id, String userName, String passwordHash)
    {
        this.id = id;
        this.username = userName;
        this.passwordHash = passwordHash;
    }
    public User(String userName, String passwordHash){
        this.username = userName;
        this.passwordHash = passwordHash;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
