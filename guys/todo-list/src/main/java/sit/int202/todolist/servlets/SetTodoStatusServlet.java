package sit.int202.todolist.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import sit.int202.todolist.models.Todo;
import sit.int202.todolist.repositories.TodoRepository;

@WebServlet(name = "SetTodoServlet", value = "/set-todo-status")
public class SetTodoStatusServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String status = req.getParameter("status");

    if (id == null || status == null || !status.equalsIgnoreCase("done")) {
      req.setAttribute("error", "Invalid todo status");
    } else {
      UUID todoId;
      try {
        todoId = UUID.fromString(id);
      } catch (IllegalArgumentException e) {
        req.setAttribute("error", "Invalid todo ID format");
        req.getRequestDispatcher("/todo-list.jsp").forward(req, resp);
        return;
      }

      Todo foundTodo = TodoRepository.findTodoById(todoId);
      if (foundTodo == null) {
        req.setAttribute("error", "Todo not found!");
      } else {
        foundTodo.setStatusDone();
        req.setAttribute("success", "Todo moved to 'done' successfully");
      }
    }
    req.getRequestDispatcher("/todo-list").forward(req, resp);
  }
}
