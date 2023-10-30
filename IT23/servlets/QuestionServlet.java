package com.example.demo1.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.demo1.models.*;

import java.io.IOException;

@WebServlet(name = "QuestionServlet", value = "/QuestionServlet")
public class QuestionServlet extends HttpServlet {
    int countCorrectAnswer = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RandomNumber randomNumber = new RandomNumber();
        HttpSession session = request.getSession();
        int num1 = randomNumber.getNum1();
        int num2 = randomNumber.getNum2();
        int answer = randomNumber.getAnswer();
        int countTotal = 3;

        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("correctAnswer", answer);
        session.setAttribute("countCorrectAnswer", countCorrectAnswer);
        session.setAttribute("countTotal", countTotal);

        getServletContext().getRequestDispatcher("/question.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RandomNumber randomNumber = new RandomNumber();
        HttpSession session = request.getSession();
        String message = null;
        String correctMessage = null;
        String congratsMessage = null;
        String userAnswer = request.getParameter("userAnswer");
        int correctAnswer = (int) session.getAttribute("correctAnswer");
        int countTotal = (int) session.getAttribute("countTotal");
        int num1 = (int) session.getAttribute("num1");
        int num2 = (int) session.getAttribute("num2");

        if (randomNumber.isNumeric(userAnswer)) {
            int userAnswerInt = Integer.parseInt(userAnswer);
            if (userAnswerInt == correctAnswer) {
                correctMessage = "Correct!";
                countCorrectAnswer++;
                if (countCorrectAnswer == countTotal) {
                    congratsMessage = "Congratulations! You got all the answers correct! and your score will be reset!";
                    countCorrectAnswer = 0;
                    request.setAttribute("congratsMessage", congratsMessage);
                }
                session.setAttribute("countCorrectAnswer", countCorrectAnswer);
                request.setAttribute("correctMessage", correctMessage);
                doGet(request, response);
            } else {
                message = "Incorrect!, The correct answer for " + num1 + " + " + num2 + " is " + correctAnswer + ".";
            }
        } else {
            message = "Invalid input!";
        }

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/question.jsp").forward(request, response);
    }
}