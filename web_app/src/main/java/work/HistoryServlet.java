package work;

import utilities.History;
import utilities.Operation;
import utilities.Operations;
import utilities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    private final static Operations operations = new Operations();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
        User user = (User) req.getSession().getAttribute("userName");

        req.getSession().setAttribute("listOfOperations", operations);

    }

}
