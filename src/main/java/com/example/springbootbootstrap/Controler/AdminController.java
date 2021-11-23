package com.example.springbootbootstrap.Controler;

import com.example.springbootbootstrap.model.Role;
import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.RoleService;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/panel")
    public String adminPanel(Authentication authentication, ModelMap model){
        User user = userService.getUser(authentication.getName());
        List<User> userList = userService.getUsersList();
        User newUser = new User();
        model.addAttribute("userList",userList);
        model.addAttribute("admin",user);
        model.addAttribute("newuser", newUser);
        return "adminpanel";
    }

    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id") int id,@RequestParam("roles") String roles, @ModelAttribute("user") User user){
       userService.updateUser(user, roles, id);
        return "redirect:/admin/panel";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userService.deleteUser(id);
        return "redirect:/admin/panel";
    }

    @PostMapping("/new")
    public String newUserAdmin(@RequestParam("roles") String roles, @ModelAttribute("user") User user){
        List<Role> roleAr = Arrays.stream(roles.split(",")).map(role-> roleService.getRole(role)).collect(Collectors.toList());
        user.setRoleList(roleAr);
        userService.save(user);
            return "redirect:/admin/panel";
    }

}
