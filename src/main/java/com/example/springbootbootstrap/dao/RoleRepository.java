package com.example.springbootbootstrap.dao;

import com.example.springbootbootstrap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRole(String role);
}
