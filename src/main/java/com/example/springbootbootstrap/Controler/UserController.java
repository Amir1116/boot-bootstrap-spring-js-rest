package com.example.springbootbootstrap.Controler;

import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String userPage(Authentication authentication, ModelMap model){
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User user = userService.getUser(currentUserName);
            User newUser = new User();
            model.addAttribute("user",user);
        }
        return "userpage";
    }
}
