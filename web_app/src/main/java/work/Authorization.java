package work;

import utilities.User;
import utilities.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/auth")
public class Authorization extends HttpServlet {

    private final static UserStorage storage = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("userName");
        String user_password = req.getParameter("password");

        Optional<User> optionalUser = storage.findByUserName(user_name);

        if (optionalUser.isPresent()) {
            System.out.println("user found");
            User user = optionalUser.get();
            if (user.getPassword().equals(user_password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect("/");
            } else {
                resp.getWriter().println("Wrong Password");
            }
        } else {
            resp.getWriter().println("User not found");
        }

    }
}
