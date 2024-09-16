package ru.kata.PP_3_1_1_Spring_Boot.dao;



import ru.kata.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void update(Long id, User updateUser);

    void delete(Long id);
}
