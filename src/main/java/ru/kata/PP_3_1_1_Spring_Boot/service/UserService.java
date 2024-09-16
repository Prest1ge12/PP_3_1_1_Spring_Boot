package ru.kata.PP_3_1_1_Spring_Boot.service;



import ru.kata.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void update(Long id, User updateUser);

    void delete(Long id);
}
