package ru.javarush.module3.quest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javarush.module3.quest.service.GameService;
import ru.javarush.module3.quest.util.PropertiesLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "init-servlet", value = "/start")
public class InitServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private GameService gameService;

    @Override
    public void init() throws ServletException {
        super.init();

        String appPath = super.getServletContext().getRealPath("");
        gameService = GameService.getInstance();
        gameService.init(appPath);

        logger.info("GameService initialized.");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            String userSessionId = request.getSession().getId();
            String userName = request.getParameter("userName");

            if (!gameService.userIsPresent(userSessionId)) {
                gameService.addNewUser(userSessionId, userName);
            }

//            response.sendRedirect(request.getContextPath() + "/questgame.jsp");

            response.setContentType("text/html");

            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Good to see you in this area, " + userName + "</h1>");
            out.println("<h2>" + "Session id is: " + userSessionId + "</h2>");
            out.println("<h3>" + "App path is: " + "</h3>");
            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Problems with InitServlet doGet(): " + e.getMessage());
        }
    }

    public void destroy() {
    }
}