package ru.kata.PP_3_1_1_Spring_Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.PP_3_1_1_Spring_Boot.dao.UserDao;
import ru.kata.PP_3_1_1_Spring_Boot.model.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }


    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        userDao.update(id, updateUser);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
