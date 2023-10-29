package sit.int202.todolist.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import sit.int202.todolist.repositories.TodoRepository;

@WebServlet(name = "AddTodoServlet", value = "/add-todo")
public class AddTodoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/add-todo.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String title = req.getParameter("title");
    if (title == null) {
      req.setAttribute("error", "Todo title must not be null!");
    } else {
      req.setAttribute("success", "New todo has been added");
      TodoRepository.addTodo(title);
    }
    req.getRequestDispatcher("/add-todo.jsp").forward(req, resp);
  }
}
