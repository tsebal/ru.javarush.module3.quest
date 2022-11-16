package ru.javarush.module3.quest.controller;

import ru.javarush.module3.quest.service.GameService;

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

    private GameService gameService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
//            if (Objects.isNull(gameService)) {
//                gameService = new GameService();
//            }
            String userSessionId = request.getSession().getId();
            String userName = request.getParameter("userName");
//            gameService.addNewUser(userSessionId, userName);

            response.setContentType("text/html");

            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "Good to see you in this area, " + userName + "</h1>");
            out.println("<h2>" + "Session id is: " + userSessionId + "</h1>");
            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}