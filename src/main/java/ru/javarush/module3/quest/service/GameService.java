package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;
import ru.javarush.module3.quest.repository.AnswerRepository;
import ru.javarush.module3.quest.repository.QuestionRepository;
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

    public static void init() {
        Map<Integer, Question> questionsMap = new HashMap<>();

        Properties questProp = PropertiesLoader.load();
        QuestionsInitializer questionsInitializer = new QuestionsInitializer(questProp);
        AnswersInitializer answersInitializer = new AnswersInitializer(questProp, questionsInitializer.getQuestionsMap());



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
