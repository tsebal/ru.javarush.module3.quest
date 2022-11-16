package ru.javarush.module3.quest.repository;

import ru.javarush.module3.quest.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> sessionToUser;

    public UserRepository() {
        this.sessionToUser = new HashMap<>();
    }

    public void addUser(String sessionId, User user) {
        sessionToUser.put(sessionId, user);
    }

    public User findUserBySessionId(String sessionId) {
        return sessionToUser.getOrDefault(sessionId, null);
    }
}
