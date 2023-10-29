package com.example.phuwamate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ToDoList {
    private String userId;
    private String username;
    private List<ToDoItem> todos = new ArrayList<>();

    public void addItem(ToDoItem newItem) {
        todos.add(newItem);
    }
}
