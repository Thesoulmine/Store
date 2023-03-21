package com.macalicestore.service;

import org.springframework.transaction.annotation.Transactional;
import com.macalicestore.entity.User;

import java.util.List;

public interface UserService {

    String encodePassword(String password);

    List<User> getUsersList();

    void deleteUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    @Transactional
    void deleteUserById(Long id);
}
