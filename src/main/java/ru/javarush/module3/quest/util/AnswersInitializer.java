package ru.javarush.module3.quest.util;

import ru.javarush.module3.quest.entity.Answer;
import ru.javarush.module3.quest.entity.Question;

import java.util.*;

public class AnswersInitializer {
    private static Properties questProp;
    private Map<Integer, Answer> answersMap;
    private Map<Integer, Question> questionsMap;
    private List<Answer> answersList;

    public AnswersInitializer(Properties questProp, Map<Integer, Question> questionsMap) {
        AnswersInitializer.questProp = questProp;
        this.answersMap = new HashMap<>();
        this.questionsMap = questionsMap;
        this.answersList = new ArrayList<>();
    }
//TODO:this:

//    public List<Answer> getAnswersList(int questionNumber) {
//        int maxAnswersPerQuestion = Integer.parseInt(questProp.getProperty("maxAnswersPerQuestion"));
//        int answersSectionFactor = Integer.parseInt(questProp.getProperty("AnswersSectionFactor"));
//
//        for (int i = 0; i < maxAnswersPerQuestion; i++) {
//            int answerId = questionNumber * answersSectionFactor + i;
//            String answerText = questProp.getProperty("Answer" + answerId, null);
//
//            if (Objects.nonNull(answerText)) {
//                Answer answer = new Answer(answerId, answerText, null);
//
//            }
//        }
//        return null;
//    }

    private void init() {
        int maxAnswersPerQuestion = Integer.parseInt(questProp.getProperty("maxAnswersPerQuestion"));
        int answersSectionFactor = Integer.parseInt(questProp.getProperty("AnswersSectionFactor"));

        for (Integer questionId : questionsMap.keySet()) {
            for (int i = 0; i < maxAnswersPerQuestion; i++) {
                int answerId = questionId * answersSectionFactor + i;
                String answerText = questProp.getProperty("Answer" + answerId, null);

                if (Objects.nonNull(answerText)) {
                    Answer answer = new Answer(answerId, answerText, null);

                }
            }
        }
    }
}
