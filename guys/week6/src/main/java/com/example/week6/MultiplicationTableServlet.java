package com.example.week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MultiplicationTableServlet", value = "/multiplication-table")
public class MultiplicationTableServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String number = req.getParameter("number");
    if (isNumberInvalid(number)) {
      req.setAttribute("error",
          "The number is not valid. Please provide a valid number.");
    } else {
      int parsedNumber = Integer.parseInt(number);
      req.setAttribute("number", parsedNumber);
    }
    req.getRequestDispatcher("/multiplication_table.jsp").forward(req, resp);
  }

  private boolean isNumberInvalid(String number) {
    if (number == null || number.isEmpty()) {
      return true;
    }
    for (char c : number.toCharArray()) {
      if (!Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }
}
