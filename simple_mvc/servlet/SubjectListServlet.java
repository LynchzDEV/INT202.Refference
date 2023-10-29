package sit202.simple.simple_mvc_lab.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit202.simple.simple_mvc_lab.entities.Subject;
import sit202.simple.simple_mvc_lab.repositories.SubjectRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@WebServlet(name = "subjectListServlet", value = "/subjectList")
public class SubjectListServlet extends HttpServlet { //controller class

    private long startTime;
    private long endTime;
    @Override
    public void init() throws ServletException {
        startTime = System.currentTimeMillis();
        //milli * 60(=1min) * 60(=1hr) * 24(=1day). We can convert using date class
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects = new SubjectRepository().findAll();
        req.setAttribute("subjects", subjects);
        // get Dispatcher and send data to jsp.
        req.getRequestDispatcher("/subject_listing.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

    @Override
    public void destroy() {
        endTime = System.currentTimeMillis();
        System.out.println("This servlet lifetime is : " + (endTime - startTime) + "millisecond");
    }
}
