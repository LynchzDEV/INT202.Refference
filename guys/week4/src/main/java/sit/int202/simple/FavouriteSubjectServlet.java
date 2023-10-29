package sit.int202.simple;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "FavouriteSubjectServlet", value = "/favourite-subject")
public class FavouriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String studentName = req.getParameter("name");
        String studentId = req.getParameter("id");
        String[] favouriteSubjects = req.getParameterValues("subjects");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your Favourite Subject</h1><hr/>");
        out.println("Student Id: " + studentId + "<br/>");
        out.println("Student Name: " + studentName + "<br/>");
        out.println("Your Favourite Subjects:<br/>");
        for (String subject : favouriteSubjects) {
            out.println("&nbsp; &nbsp; - " + subject + "<br/>");
        }

        // Output parameters from the request map
        Map<String, String[]> params = req.getParameterMap();
        out.println("<br/>Request Parameters from Map:<br/>");
        out.println("---------------<br/>");
        out.println("Student Id: " + params.get("id")[0] + "<br/>");
        out.println("Student Name: " + params.get("name")[0] + "<br/>");
        out.println("Your Favourite Subjects:<br/>");
        for (String subject : params.get("subjects")) {
            out.println("&nbsp; &nbsp; - " + subject + "<br/>");
        }

        // Closing HTML tags and links
        out.println("<hr/>");
        out.println("<a href=\"favourite_subject.html\">Back</a>");
        out.println("</body></html>");
    }
}
