package work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;

@WebServlet(urlPatterns = "/")
public class MainServ extends HttpServlet {


    //default logger
//    private Logger logger = Logger.getLogger("MainServ");
//    private Logger logger = Logger.getLogger(this.getClass());

    private Logger logger = LoggerFactory.getLogger(MainServ.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        logger.log(Level.INFO,"use this " + req.getRemoteAddr());
//        log("Message); servlet logger method

        logger.info("hello from loggs");

//add configuration to Log4j
        //    logger.info("use this");
        getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }


}
