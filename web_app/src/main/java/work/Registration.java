package work;

import utilities.User;
import utilities.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class Registration extends HttpServlet {

    private final static UserStorage storage = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        storage.add_user(user);
        resp.sendRedirect("/");

        getServletContext().setAttribute("dataAdded", true);

        System.out.println(user.getUserName());
    }
}
