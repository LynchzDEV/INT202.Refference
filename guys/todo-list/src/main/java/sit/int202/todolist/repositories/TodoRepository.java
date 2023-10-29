package sit.int202.todolist.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import sit.int202.todolist.constants.Status;
import sit.int202.todolist.models.Todo;

public class TodoRepository {

  private TodoRepository() {
  }

  private static HashMap<UUID, Todo> todos = new HashMap<>();

  public static Todo addTodo(String title) {
    UUID todoId = UUID.randomUUID();
    Todo newTodo = new Todo(todoId, title, Status.TODO);
    todos.put(todoId, newTodo);
    return newTodo;
  }

  public static Map<UUID, Todo> findAll() {
    return Collections.unmodifiableMap(todos);
  }

  public static Todo findTodoById(UUID todoId) {
    return todos.get(todoId);
  }
}
