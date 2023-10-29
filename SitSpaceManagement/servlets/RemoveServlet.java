package com.example.kuay.servlets;

import com.example.kuay.models.AllStudent;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AllStudent students = (AllStudent) session.getAttribute("students");

        int idR = Integer.parseInt(req.getParameter("IDr"));

        if (students.checkStudentInit(idR) && students != null) {
            students.removeStudent(idR);
            System.out.println("removed");
            session.setAttribute("Message", "Removed student ID " + idR);
        } else {
            System.out.println("error");
            session.setAttribute("Message", "Don't have student ID " + idR + " in the list.");
        }
//        resp.sendRedirect("index.jsp");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
