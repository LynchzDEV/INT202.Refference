package com.example.kuay.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllStudent {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {
        students.sort((s1, s2) -> s1.getId() - s2.getId());
        return students;
    }


    public boolean checkStudentInit(int id) {
        return students.stream()
                .anyMatch(s -> s.getId() == id);
    }
}
