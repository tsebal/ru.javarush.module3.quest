package ru.javarush.module3.quest.service;

import ru.javarush.module3.quest.entity.Question;
import ru.javarush.module3.quest.repository.AnswerRepository;
import ru.javarush.module3.quest.repository.QuestionRepository;

import java.util.List;

public class GameService {
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

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
