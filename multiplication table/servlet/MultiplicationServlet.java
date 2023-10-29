package com.smart.smart02;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication_table")
public class MultiplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/multiplication_table.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberStr = request.getParameter("number");

        if (numberStr != null && !numberStr.isEmpty()) {
            try {
                int num = Integer.parseInt(numberStr);

                String[] table1 = new String[12];
                for (int i = 1; i <= 12; i++) {
                    table1[i - 1] = num + " × " + i;
                }

                request.setAttribute("multiplicationTable", table1);
                request.setAttribute("number", num);

                int[] table2 = new int[12];
                for (int i = 1; i <= 12; i++) {
                    table2[i - 1] = num * i;
                }

                request.setAttribute("multiplicationTableResult", table2);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/multiplication_table.jsp");
                dispatcher.forward(request, response);
            } catch (NumberFormatException e) {
                response.getWriter().println("Invalid number format.");
            }
        } else {
            response.getWriter().println("Please provide a number.");
        }
    }
}
