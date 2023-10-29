package sit.int202.sitspace.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sit.int202.sitspace.errors.StudentDuplicatedError;
import sit.int202.sitspace.models.Student;

public class StudentRepository {

  private static List<Student> students = new ArrayList<>();

  public static void addNewStudent(Student newStudent)
      throws StudentDuplicatedError {
    if (students.stream().anyMatch(
        (Student student) -> student.getId() == newStudent.getId())) {
      throw new StudentDuplicatedError("Duplicated Student ID");
    }
    students.add(newStudent);
  }

  public static void removeStudent(int studentId) {
    students = students.stream()
        .filter((student -> student.getId() != studentId)).toList();
  }

  public static List<Student> findAll() {
    return Collections.unmodifiableList(students);
  }
}
