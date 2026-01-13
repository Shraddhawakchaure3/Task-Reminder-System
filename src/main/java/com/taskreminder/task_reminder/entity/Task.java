package com.taskreminder.task_reminder.entity;

import com.taskreminder.task_reminder.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime dueBy;

    private String userName;

    private String email;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // 🔹 MANUAL GETTERS (FIXES YOUR ERROR)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDueBy() {
        return dueBy;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // 🔹 OPTIONAL SETTERS (needed for POST requests)
    public void setName(String name) {
        this.name = name;
    }

    public void setDueBy(LocalDateTime dueBy) {
        this.dueBy = dueBy;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
