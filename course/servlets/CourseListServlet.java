package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.CourseRepository;
import sit.int202.register.models.Semester;
import sit.int202.register.models.Subject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CourseListServlet", value = "/course-list")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        if(sc.getAttribute("semesters") == null){
            sc.setAttribute("semesters", Semester.getAllSemesterText());
        }
        request.setAttribute("semesters", Semester.getAllSemesterText());
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();

        if(request.getAttribute("registeredSubject") != null){
           
        }

        if (parameterMap.get("semester")==null) {
            doGet(request,response);
            return;
        }
        int semester = Integer.valueOf(parameterMap.get("semester")[0]);
        request.setAttribute("semesters", Semester.getAllSemesterText());
        request.setAttribute("selectedSemester", semester);
        request.setAttribute("subjects", CourseRepository.getSubjects(semester));
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }
}
