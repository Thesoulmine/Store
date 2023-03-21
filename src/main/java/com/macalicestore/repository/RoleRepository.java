package com.macalicestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.macalicestore.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(@Param("role") String role);
}
