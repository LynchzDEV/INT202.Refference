package sit.int202.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.simple.entities.Subject;
import sit.int202.simple.repositories.SubjectRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SubjectListServlet", value = "/subject-list")
public class SubjectListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubjectRepository repository = new SubjectRepository();

        resp.setContentType("text/html");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>");
            out.println("<table><caption>Subject List</caption>");
            out.println("<thead><tr>");
            out.println("<th>Course No.</th><th>Course Name</th><th>Credit</th>");
            out.println("</tr></thead><tbody>");

            for (Subject subject : repository.findAll()) {
                out.println("<tr>");
                out.println("<td>" + subject.getId() + "</td>");
                out.println("<td>" + subject.getTitle() + "</td>");
                out.println("<td>" + subject.getCredit() + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody></table>");
            out.println("</body></html>");
        }
    }
}
