package sit.int202.register.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CourseRegisterHistoryServlet", value = "/course-registered-history")
public class CourseRegisterHistoryServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("courseRegistered") == null) {
      req.setAttribute("error", "No data yet!");
    }
    getServletContext().getRequestDispatcher("/user_registered.jsp")
        .forward(req, resp);
  }
}
