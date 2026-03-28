package com.macalicestore.user;

import java.util.List;

public interface UserService {

    List<User> getUsersList();

    void deleteUser(User user);

    User getUserById(Long id);

    User getUserByUsername(String username);

    void saveUser(User user);

    void deleteUserById(Long id);
}
