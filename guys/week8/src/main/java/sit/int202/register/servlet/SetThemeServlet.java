package sit.int202.register.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetThemeServlet", value = "/set-theme")
public class SetThemeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/set_theme.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String selectedTheme = req.getParameter("theme");
    Cookie cookie = new Cookie("theme", selectedTheme);
    cookie.setMaxAge(60 * 60 * 24);
    resp.addCookie(cookie);
    resp.sendRedirect("index.jsp");
  }
}
