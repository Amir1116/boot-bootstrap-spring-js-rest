package com.example.springbootbootstrap.dao;

import com.example.springbootbootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByName(String name);
}
