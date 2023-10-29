package sit.int202.sitspace.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import sit.int202.sitspace.viewModel.ViewStudent;
import sit.int202.sitspace.repositories.StudentRepository;

@WebServlet(name = "AllStudentDataServlet", value = "/all-student-data")
public class AllStudentDataServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("students", generateStudentsData());
    req.getRequestDispatcher("/all_student_data.jsp").forward(req, resp);
  }

  private List<ViewStudent> generateStudentsData() {
    return StudentRepository.findAll().stream()
        .map(student -> {
          float score = student.getScore();
          char grade = calculateGrade(score);
          return new ViewStudent(student.getId(), student.getName(), score,
              grade);
        })
        .toList();
  }

  private char calculateGrade(float score) {
    if (score >= 80) {
      return 'A';
    }
    if (score >= 70) {
      return 'B';
    }
    if (score >= 60) {
      return 'C';
    }
    if (score >= 50) {
      return 'D';
    }
    return 'F';
  }
}
