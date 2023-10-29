package sit.int202.sitspace.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import sit.int202.sitspace.errors.StudentDuplicatedError;
import sit.int202.sitspace.models.Student;
import sit.int202.sitspace.repositories.StudentRepository;

@WebServlet(name = "AddStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    resp.sendRedirect("add-remove-student");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String name = req.getParameter("name");
    String score = req.getParameter("score");
    if (id == null || name == null || score == null) {
      req.setAttribute("error",
          "All student data must be provided to add new student!");
    } else {
      try {
        Student newStudent = new Student(
            Integer.parseInt(id),
            name,
            Float.parseFloat(score));
        StudentRepository.addNewStudent(newStudent);
        req.setAttribute("success",
            "Student with ID " + id + " has been added!");
      } catch (StudentDuplicatedError error) {
        req.setAttribute("error", error.getMessage());
      }
    }
    req.getRequestDispatcher("/add_remove_student.jsp").forward(req, resp);
  }
}
