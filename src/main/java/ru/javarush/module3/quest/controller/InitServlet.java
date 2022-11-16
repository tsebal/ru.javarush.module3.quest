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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "init-servlet", value = "/start")
public class InitServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private GameService gameService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String appPath = request.getServletContext().getRealPath("");
            String userSessionId = request.getSession().getId();
            String userName = request.getParameter("userName");

            if (Objects.isNull(gameService)) {
                gameService = GameService.getInstance();
                gameService.init(appPath);
            }
            gameService.addNewUser(userSessionId, userName);

            response.setContentType("text/html");

            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Good to see you in this area, " + userName + "</h1>");
            out.println("<h2>" + "Session id is: " + userSessionId + "</h2>");
            out.println("<h3>" + "App path is: " + appPath + "</h3>");
            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Problems with InitServlet doGet(): " + e.getMessage());
        }
    }

    public void destroy() {
    }
}