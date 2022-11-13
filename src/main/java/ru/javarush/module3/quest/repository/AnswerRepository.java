package ru.javarush.module3.quest.repository;

import ru.javarush.module3.quest.entity.Answer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AnswerRepository {
    private Map<Integer, Answer> idToAnswer;

    public AnswerRepository(Map<Integer, Answer> idToAnswer) {
        this.idToAnswer = idToAnswer;
    }

    Optional<Answer> findById(int id) {
        throw new UnsupportedOperationException();
    }

    List<Answer> findByIds(List<Long> ids) {
        throw new UnsupportedOperationException();
    }
}
