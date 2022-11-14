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

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }
}
