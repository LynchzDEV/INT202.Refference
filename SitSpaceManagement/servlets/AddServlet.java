package com.example.kuay.servlets;

import com.example.kuay.models.AllStudent;
import com.example.kuay.models.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AllStudent students = (AllStudent) session.getAttribute("students");

        if (students == null) {
            students = new AllStudent();
            session.setAttribute("students", students);
        }

        int idA = Integer.parseInt(req.getParameter("IDa"));
        String name = req.getParameter("Name");
        int score = Integer.parseInt(req.getParameter("Score"));

        String errorMessage = null;
        if (idA <= 0) {
            errorMessage = "ID must be greater than 0";
        } else if (score < 0) {
            errorMessage = "Score must be greater than 0";
        } else if (score > 100) {
            errorMessage = "Score must be less than or equal to 100";
        } else if (name == null || name.trim().isEmpty()) {
            errorMessage = "All fields are required";
        }

        if (errorMessage != null) {
            System.out.println("ERROR: " + errorMessage);
            req.setAttribute("Message", errorMessage);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;  // stop the execution here
        }

        // If no error, continue with student addition logic
        String grade;
        if (score >= 80) {
            grade = "A";
        } else if (score >= 70) {
            grade = "B";
        } else if (score >= 60) {
            grade = "C";
        } else if (score >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        Student student = new Student(idA, name, score, grade);
        students.addStudent(student);
        System.out.println("ADDED: " + student);
        session.setAttribute("students", students);
        req.setAttribute("Message", "ADDED, " + "\nID: " + student.getId() + " ,GRADE: " + student.getGrade());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}