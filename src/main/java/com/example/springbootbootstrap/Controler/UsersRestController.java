package com.example.springbootbootstrap.Controler;


import com.example.springbootbootstrap.model.Role;
import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.RoleService;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersRestController {

    private final UserService userService;


    @Autowired
    public UsersRestController(UserService userService){
        this.userService = userService;

    }


    @GetMapping("/user/{id}")
    public User findOne(@PathVariable("id") Integer id){
        User user =  userService.getUser(id);
        List<Role>  roleList =  user.getRoleList();
        System.out.println(roleList);
        return user;
    }
}
