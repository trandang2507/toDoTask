package com.project.todo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private boolean completed = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Task(){}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {return description;}

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) { this.description = description; }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
