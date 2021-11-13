package com.example.springbootbootstrap.Controler;


import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.RoleService;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsersRestController {

    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UsersRestController(UserService userService, RoleService roleService,PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("users")
    public List<User> allUsers(){
        return userService.listUsers();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable("id") Integer id){
         return userService.getUser(id);
    }

    @PostMapping("users")
    public User addUser(@RequestBody User user){
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        userService.save(user);
        return user;
    }

    @PutMapping("users")
    public List<User> putUser(@RequestBody User user){
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        userService.save(user);
        return userService.listUsers();

    }

    @DeleteMapping("users/{id}")
    public List<User> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return userService.listUsers();
    }
}
