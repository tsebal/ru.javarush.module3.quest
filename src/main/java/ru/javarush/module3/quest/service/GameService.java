package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.User;
import ru.javarush.module3.quest.repository.AnswerRepository;
import ru.javarush.module3.quest.repository.QuestionRepository;
import ru.javarush.module3.quest.repository.UserRepository;
import ru.javarush.module3.quest.util.AnswersInitializer;
import ru.javarush.module3.quest.util.PropertiesLoader;
import ru.javarush.module3.quest.util.QuestionsInitializer;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class GameService {
    private static GameService instance;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private UserRepository userRepository;

    public static synchronized GameService getInstance() {
        if (instance == null)
            instance = new GameService();
        return instance;
    }

    public GameService() {
    }

    public void init(String appPath) {
        Properties questProp = PropertiesLoader.load(appPath);
        QuestionsInitializer questionsInitializer = new QuestionsInitializer(questProp);
        AnswersInitializer answersInitializer = new AnswersInitializer(questProp, questionsInitializer.getQuestionsMap());
        this.questionRepository = new QuestionRepository(questionsInitializer.getQuestionsMap());
        this.answerRepository = new AnswerRepository(answersInitializer.getAnswersMap());
        this.userRepository = new UserRepository();
    }

    public void addNewUser(String sessionId, String userName) {
        userRepository.addUser(sessionId, new User(userName));
    }

    public boolean userIsPresent(String sessionId) {
        return Objects.nonNull(userRepository.findUserBySessionId(sessionId));
    }

    public String getUserNameBySessionId(String sessionId) {
        User currentUser = userRepository.findUserBySessionId(sessionId).get();
        return currentUser.getName();
    }

//    public QuestionDto findQuestionById(Long id) {
//        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException());
//        List<Answer> answers = answerRepository.findByIds(question.getAnswersId());
//
//        // List<Answer> answers ---->  List<AnswerDto> answers
//
//        // questionId =
//        return new QuestionDto();
//    }
}
