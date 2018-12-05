package net.ukr.kondrashev;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    static final String message = "<html><head><title>BLOG</title></head><body>%s</body></html>";
    static final Map<String, User> usersList = new HashMap<>();

    static {
        User admin = new User("admin", "admin", "Administrator", "admin");
        usersList.put("admin", admin);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname = request.getParameter("name");

        if (request.getParameter("newuser").equals("yes")) {
            usersList.put(login, new User(login, password, surname, "author"));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (usersList.containsKey(login) && password.equals(usersList.get(login).getPassword())) {
            response.getWriter().println(String.format(message, "Wellcome " + usersList.get(login).getSurname() + "!!!"));
            request.getSession().setAttribute("user", usersList.get(login));
            request.getRequestDispatcher("/Wellcome.jsp").forward(request, response);
        } else {
            response.sendRedirect("/Registration.jsp");
        }
    }
}
