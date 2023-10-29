package sit.int202.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.simple.entities.Subject;
import sit.int202.simple.repositories.SubjectRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectListServlet", value = "/subject-list")
public class SubjectListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectRepository repository = new SubjectRepository();
        List<Subject> subjects = repository.findAll();
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("/subject_list.jsp").forward(req, resp);
    }
}
