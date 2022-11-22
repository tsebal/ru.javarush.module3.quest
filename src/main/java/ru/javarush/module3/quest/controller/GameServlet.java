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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "game-servlet", value = "/questgame")
public class GameServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    private GameService gameService;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            gameService = GameService.getInstance();
        } catch (Exception e) {
            logger.error("Problems with GameServlet init(): " + e.getMessage());
        }
        logger.info("GameServlet initialized.");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String userSessionId = session.getId();
            int answerId = Integer.parseInt(request.getParameter("id"));
            int nextQuestionId = gameService.findNextQuestionIdByAnswerId(answerId);

            session.setAttribute("userScore", gameService.getUserScore(userSessionId));
            session.setAttribute("question", gameService.findQuestionById(nextQuestionId));
            session.setAttribute("answers", gameService.findAnswersByQuestionId(nextQuestionId));

            response.sendRedirect(request.getContextPath() + "/questgame.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Problems with GameServlet doPost(): " + e.getMessage());
        }
    }
}