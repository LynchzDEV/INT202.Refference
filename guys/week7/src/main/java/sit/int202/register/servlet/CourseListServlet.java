package sit.int202.register.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import sit.int202.register.models.CourseRepository;
import sit.int202.register.models.Semester;

@WebServlet(name = "CourseListServlet", value = "/course-list")
public class CourseListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext context = getServletContext();
    context.setAttribute("semesters", Semester.getAllSemesterText());
    getServletContext().getRequestDispatcher("/course_list.jsp")
        .forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Map<String, String[]> parameterMap = req.getParameterMap();
    req.setCharacterEncoding("UTF-8");
    if (parameterMap.get("semester") == null) {
      doGet(req, resp);
      return;
    }

    int semester = Integer.parseInt(parameterMap.get("semester")[0]);
    req.setAttribute("selectedSemester", semester);
    req.setAttribute("subjects", CourseRepository.getSubjects(semester));
    getServletContext().getRequestDispatcher("/course_list.jsp")
        .forward(req, resp);
  }
}
