package sit.int202.register.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import sit.int202.register.models.CourseRegistered;
import sit.int202.register.models.CourseRepository;

@WebServlet(name = "RegisterCourseServlet", value = "/register")
public class RegisterCourseServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Map<String, String[]> parameterMap = req.getParameterMap();
    int semester = Integer.parseInt(parameterMap.get("semester")[0]);

    HttpSession session = req.getSession();
    CourseRegistered courseRegistered = (CourseRegistered) session.getAttribute(
        "courseRegistered");
    if (courseRegistered == null) {
      courseRegistered = new CourseRegistered();
      session.setAttribute("courseRegistered", courseRegistered);
    }

    for (String subjectId : parameterMap.get("registeredSubjects")) {
      courseRegistered.registerSubject(semester,
          CourseRepository.getSubject(semester, subjectId));
    }

    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
  }
}
