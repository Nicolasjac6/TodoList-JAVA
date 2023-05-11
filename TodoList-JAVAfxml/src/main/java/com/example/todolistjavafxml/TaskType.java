package com.example.todolistjavafxml;

public class TaskType {
    private int id;
    private String label;
    private String colorCode;

    public TaskType(int id, String label, String colorCode) {
        this.id = id;
        this.label = label;
        this.colorCode = colorCode;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return label;
    }
}