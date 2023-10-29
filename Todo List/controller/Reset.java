package com.example.phuwamate.controller;

import com.example.phuwamate.model.ToDoList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "Reset", value = "/Reset")
public class Reset extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ToDoList toDoList = (ToDoList) session.getAttribute("toDoList");

        if (toDoList != null) {
            req.setAttribute("toDoList", toDoList);
        }
        req.getRequestDispatcher("todoSite.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ToDoList toDoList = (ToDoList) session.getAttribute("toDoList");

        session.setAttribute("toDoList", null);
        req.getRequestDispatcher("todoSite.jsp").forward(req, resp);
    }
}
 
