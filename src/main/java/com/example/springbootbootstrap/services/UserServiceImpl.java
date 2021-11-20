package com.example.springbootbootstrap.services;
import com.example.springbootbootstrap.dao.UserRepository;
import com.example.springbootbootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> optional =  userRepository.findById(id);
        if(optional.isPresent()){
            user = optional.get();
        }
        return user;
    }

    @Override
    @Transactional
    public void updateUser( User user) {
        userRepository.save(user);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
