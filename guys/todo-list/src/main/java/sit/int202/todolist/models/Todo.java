package sit.int202.todolist.models;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import sit.int202.todolist.constants.Status;

@Data
@AllArgsConstructor
public class Todo {

  private UUID id;
  private String title;
  private Status status;

  public void setStatusDone() {
    status = Status.DONE;
  }
}
