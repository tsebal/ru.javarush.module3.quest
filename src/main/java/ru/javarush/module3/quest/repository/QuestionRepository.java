package ru.javarush.module3.quest.repository;

import ru.javarush.module3.quest.entity.Question;

import java.util.Map;
import java.util.Optional;

public class QuestionRepository {
    private Map<Integer, Question> idToQuestion;

    public QuestionRepository(Map<Integer, Question> idToQuestion) {
        this.idToQuestion = idToQuestion;
    }

    Optional<Question> findById(Long id) {
        return Optional.ofNullable(idToQuestion.get(id));
    }
}
