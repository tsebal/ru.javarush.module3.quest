package ru.javarush.module3.quest.entity;

import java.util.List;

public class Question {
    private int id;
    private String text;
    private List<Answer> answers;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }
}
