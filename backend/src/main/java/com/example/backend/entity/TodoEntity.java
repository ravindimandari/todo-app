package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class TodoEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// it will number the whole thing easily
    @Id
    private long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt=LocalDateTime.now();

//Constructors
    public  TodoEntity(){}
    public TodoEntity(String title,String description){
        this.title=title;
        this.description=description;
        this.completed=false;
        this.createdAt=LocalDateTime.now();
    }
    //getterss
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted(){
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
