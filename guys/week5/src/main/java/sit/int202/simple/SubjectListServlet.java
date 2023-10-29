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
    private long startTime;

    @Override
    public void init() {
        startTime = System.currentTimeMillis();
        System.out.println("=======================");
        System.out.println("The SubjectListServlet has been started!");
        System.out.println("Start Time is: " + startTime);
        System.out.println("=======================");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectRepository repository = new SubjectRepository();
        List<Subject> subjects = repository.findAll();
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("/subject_list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        long stoppedTime = System.currentTimeMillis();
        long runningDuration = (startTime - stoppedTime) / 1000 / 60;
        System.out.println("=======================");
        System.out.println("The SubjectListServlet has been stopped!");
        System.out.println("Stop Time is: " + stoppedTime);
        System.out.println("Total Duration is: " + runningDuration + "m");
        System.out.println("=======================");
    }
}