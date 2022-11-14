package ru.javarush.module3.quest.entity;

public class Answer {
    private int id;
    private String text;
    private Question nextQuestion;

    public Answer(int id, String text, Question nextQuestion) {
        this.id = id;
        this.text = text;
        this.nextQuestion = nextQuestion;
    }
}
