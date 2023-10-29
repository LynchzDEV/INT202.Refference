package com.example.jps_servlet_tutorials;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SquareNumber", value = "/square-number")
public class SquareNumber extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        double num1 = (double) session.getAttribute("num1");
        double num2 = (double) session.getAttribute("num2");
        double sqNum1 = Math.pow(num1,2);
        double sqNum2 = Math.pow(num2,2);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Output number 1: " + sqNum1);
        printWriter.println("Output number 2: " + sqNum2);
    }
}
