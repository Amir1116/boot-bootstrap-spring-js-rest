package com.example.springbootbootstrap.Controler;

import com.example.springbootbootstrap.model.Role;
import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.RoleService;
import com.example.springbootbootstrap.services.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    private UserService userService;


    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/panel")
    public String adminPanel(Authentication authentication, ModelMap model){
        User user = userService.getUser(authentication.getName());
        model.addAttribute("admin",user);
        return "adminpanel";
    }
}
