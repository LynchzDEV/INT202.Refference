package com.example.phuwamate.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItem {
    private int id;
    private String header;
    private String des;
    private String status;
    private String priority;
}
