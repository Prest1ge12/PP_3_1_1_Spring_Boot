package ru.kata.PP_3_1_1_Spring_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.kata.PP_3_1_1_Spring_Boot.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updateUser) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser == null) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        existingUser.setName(updateUser.getName());
        existingUser.setAge(updateUser.getAge());
        entityManager.merge(existingUser);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        entityManager.remove(user);
    }
}