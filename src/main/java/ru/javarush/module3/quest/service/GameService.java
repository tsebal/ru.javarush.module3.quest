package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;
import ru.javarush.module3.quest.entity.User;
import ru.javarush.module3.quest.repository.AnswerRepository;
import ru.javarush.module3.quest.repository.QuestionRepository;
import ru.javarush.module3.quest.repository.UserRepository;
import ru.javarush.module3.quest.util.AnswersInitializer;
import ru.javarush.module3.quest.util.PropertiesLoader;
import ru.javarush.module3.quest.util.QuestionsInitializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GameService {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private UserRepository userRepository;

    public GameService() {
        Properties questProp = PropertiesLoader.load();
        QuestionsInitializer questionsInitializer = new QuestionsInitializer(questProp);
        AnswersInitializer answersInitializer = new AnswersInitializer(questProp, questionsInitializer.getQuestionsMap());
        this.questionRepository = new QuestionRepository(questionsInitializer.getQuestionsMap());
        this.answerRepository = new AnswerRepository(answersInitializer.getAnswersMap());
        this.userRepository = new UserRepository();
    }

    public void addNewUser(String sessionId, String userName) {
        userRepository.addUser(sessionId, new User(userName));
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
