package sit.int202.sitspace.viewModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sit.int202.sitspace.models.Student;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ViewStudent extends Student {

  private char grade;

  public ViewStudent(int id, String name, float score, char grade) {
    super(id, name, score);
    this.grade = grade;
  }
}
