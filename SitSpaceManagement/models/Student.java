package com.example.kuay.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int score;
    private String grade;
}
