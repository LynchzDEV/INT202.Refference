package com.example.jps_servlet_tutorials;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNumber", value = "/adding-number")
public class AddNumber extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        double sum = num1 + num2;

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("sum", sum);

        if(req.getParameter("option").equals("multiply")){
            //Not redirect but keep data and send data to another servlet
            RequestDispatcher rq = req.getRequestDispatcher("/multiply-value");
            rq.forward(req, resp);

            //If you need to redirect you can use send redirect to ().....
//            resp.sendRedirect("multiply-value");
        } else if(req.getParameter("option").equals("square")){
            // url rewriting
            HttpSession session = req.getSession();
            session.setAttribute("num1", num1);
            session.setAttribute("num2", num2);
            resp.sendRedirect("square-number");
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("Result is : " + sum);
        }


    }
}
