package com.example.springbootbootstrap.Controler;


import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.RoleService;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public UsersRestController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("users")
    public ResponseEntity<List<User>> allUsers() {
        List<User> listUsers = userService.listUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("users")
    public ResponseEntity<List<User>> putUser(@RequestBody User user) {
        String pass = user.getPassword();
        user.setPassword(passwordEncoder.encode(pass));
        userService.save(user);
        List<User> listUsers = this.userService.listUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);

    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(this.userService.listUsers(), HttpStatus.OK);
    }
}
