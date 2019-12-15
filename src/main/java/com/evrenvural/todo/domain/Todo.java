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

    private int importantValue;

    private Date date;

    public Todo(String title, String description, int importantValue, Date date) {
        this.title = title;
        this.description = description;
        this.importantValue = importantValue;
        this.date = date;
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

    public int getImportantValue() {
        return importantValue;
    }

    public void setImportantValue(int importantValue) {
        this.importantValue = importantValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Todo(){

    }
}
