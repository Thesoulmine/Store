package com.macalicestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.macalicestore.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
