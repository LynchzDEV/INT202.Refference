package com.example.jps_servlet_tutorials;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiplyNumber", value = "/multiply-value")
public class MultiplyNumber extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 =(double) req.getAttribute("num1");
        double num2 =(double) req.getAttribute("num2");
        double sum =(double) req.getAttribute("sum");
        double mulResult = num1*num2;

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Adding Result is : " + sum);
        printWriter.println("Multiply value is : " + mulResult);
    }
}
