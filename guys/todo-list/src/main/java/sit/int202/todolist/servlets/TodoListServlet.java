package sit.int202.todolist.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import sit.int202.todolist.constants.Status;
import sit.int202.todolist.models.Todo;
import sit.int202.todolist.repositories.TodoRepository;

@WebServlet(name = "TodoListServlet", value = "/todo-list")
public class TodoListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Map<UUID, Todo> todos = TodoRepository.findAll();
    Map<UUID, Todo> waitingTodos = filterTodosByStatus(todos, Status.TODO);
    Map<UUID, Todo> doneTodos = filterTodosByStatus(todos, Status.DONE);
    req.setAttribute("waitingTodos", new ArrayList<>(waitingTodos.values()));
    req.setAttribute("doneTodos", new ArrayList<>(doneTodos.values()));
    req.getRequestDispatcher("/todo-list.jsp").forward(req, resp);
  }

  private Map<UUID, Todo> filterTodosByStatus(Map<UUID, Todo> todos,
      Status status) {
    return todos.entrySet().stream()
        .filter(entry -> entry.getValue().getStatus().equals(status))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
