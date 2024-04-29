package ru.sklis.spring_boot_security.service;

import ru.sklis.spring_boot_security.model.User;

import java.util.List;


public interface UserService {
    List<User> findAll();

    User getById(Long id);

    User findUserByUsername(String username);

    void save(User user);

    void deleteById(Long id);

    void update(User user);

}