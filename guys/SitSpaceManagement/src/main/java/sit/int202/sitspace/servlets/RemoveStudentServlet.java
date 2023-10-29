package sit.int202.sitspace.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import sit.int202.sitspace.repositories.StudentRepository;

@WebServlet(name = "RemoveStudentServlet", value = "/remove-student")
public class RemoveStudentServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    resp.sendRedirect("add-remove-student");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    if (id == null) {
      req.setAttribute("error", "Student ID must be provided!");
    } else {
      StudentRepository.removeStudent(Integer.parseInt(id));
      req.setAttribute("success", "Successfully remove student with id " + id);
    }
    req.getRequestDispatcher("/add_remove_student.jsp").forward(req, resp);
  }
}
