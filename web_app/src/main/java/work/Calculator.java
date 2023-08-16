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

@WebServlet(urlPatterns = "/calc")
public class Calculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double num1 = Double.parseDouble(req.getParameter("num1"));
        Double num2 = Double.parseDouble(req.getParameter("num2"));

        Operation operation = new Operation();
        operation.setNum1(num1);
        operation.setNum2(num2);
        operation.setUser((User) req.getSession().getAttribute("currentUser"));
        Operations operations = new Operations();
        double result = operations.calculate(num1, num2, req.getParameter("operation"));
        operation.setResult("" + result);

        History history = new History();
        history.add_operation(operation);

        req.getSession().setAttribute("result", result);

        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);

    }


}
