package com.example.springbootbootstrap.dao;



import com.example.springbootbootstrap.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> listUsers();
    void deleteUser(int id);
    User getUser(int id);
    void updateUser( User user);
    User getUser(String name);
}
