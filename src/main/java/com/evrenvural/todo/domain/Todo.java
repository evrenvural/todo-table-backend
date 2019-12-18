package com.evrenvural.todo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String title;

    private String description;

    private String important;

    private String status;

    private Long date;

    public Todo(Long id, String title, String description, String importantValue, Long date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.important = importantValue;
        this.date = date;
    }

    public Todo(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportantValue() {
        return important;
    }

    public void setImportantValue(String importantValue) {
        this.important = importantValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
