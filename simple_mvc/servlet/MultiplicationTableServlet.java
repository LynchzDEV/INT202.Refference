package sit202.simple.simple_mvc_lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MultiplicationTableServlet", value = "/multiplicationTable")
public class MultiplicationTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("number");
        if (param == null || !isDigit(param)) req.setAttribute("message", "Invalid parameter or No parameter!");
        req.getRequestDispatcher("/multiplicationTable.jsp").forward(req, resp);
    }

    private boolean isDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
