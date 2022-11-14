package ru.javarush.module3.quest.entity;

public class User {
    private String name;
    private int score;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
