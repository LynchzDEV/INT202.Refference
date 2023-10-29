package com.example.phuwamate.controller;

import com.example.phuwamate.model.ToDoItem;
import com.example.phuwamate.model.ToDoList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    int id = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ToDoList toDoList = (ToDoList) session.getAttribute("toDoList");

        if (toDoList != null) {
            req.setAttribute("toDoList", toDoList);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ToDoList toDoList = (ToDoList) session.getAttribute("toDoList");

        if (toDoList == null) {
            toDoList = new ToDoList();
            session.setAttribute("toDoList", toDoList);
        }

        String header = req.getParameter("header");
        String des = req.getParameter("des");
        String priority = req.getParameter("priority");

        if (header != null && des != null && priority != null) {
            ToDoItem newItem = new ToDoItem(id++, header, des, "PENDING", priority);
            toDoList.addItem(newItem);
            System.out.println(newItem);
            session.setAttribute("toDoList", toDoList);
        } else {
            System.out.println("ERROR");
            req.setAttribute("errorMessage", "All fields are required");
        }
        req.getRequestDispatcher("/todoSite.jsp").forward(req, resp);

    }
}
