package com.evrenvural.todo.dto;

public class TodoDTO {

    private String title;

    private String description;

    private String importantValue;

    private Long date;

    public TodoDTO(String title, String description, String importantValue, Long date) {
        this.title = title;
        this.description = description;
        this.importantValue = importantValue;
        this.date = date;
    }

    public TodoDTO(){

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
        return importantValue;
    }

    public void setImportantValue(String importantValue) {
        this.importantValue = importantValue;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
