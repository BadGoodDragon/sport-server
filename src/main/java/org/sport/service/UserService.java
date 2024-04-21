package org.sport.service;

import org.sport.domain.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> getAll();
    User getByName(String username);
    User update(String username, User user);
    User updateCoords(String username, User user);
    void deleteByName(String username);
    User getByToken(String token);
    User updateToken(String username, User user);
}
