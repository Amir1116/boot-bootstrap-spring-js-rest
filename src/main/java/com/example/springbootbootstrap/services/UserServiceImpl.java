package com.example.springbootbootstrap.services;

import com.example.springbootbootstrap.dao.UserDao;
import com.example.springbootbootstrap.model.Role;
import com.example.springbootbootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleService roleService){
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser( User user, String roles, int id) {
        User userOut = getUser(id);
        userOut.setUsername(user.getUsername());
        userOut.setEmail(user.getEmail());
        userOut.setName(user.getName());
        userOut.setLastName(user.getLastName());
        userOut.setPassword(user.getPassword());
        userOut.setAge(user.getAge());
        List<Role> roleList = userOut.getRoleList();
        if ((roles.split(",")).length == 0) {
            userOut.setRoleList(roleList);
        } else {
            List<Role> roleAr = Arrays.stream(roles.split(",")).map(roleService::getRole).collect(Collectors.toList());
            userOut.setRoleList(roleAr);
        }
        userDao.updateUser(userOut);
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    public User findOne(int id){
        return userDao.getUser(id);
    }
}
