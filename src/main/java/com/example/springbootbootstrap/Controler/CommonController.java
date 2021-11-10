package com.example.springbootbootstrap.Controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {

    @RequestMapping()
    public String mainPage(){
        return  "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "loginpage";
    }

    @PostMapping("/login")
    public String loginIn(){
        return "redirect:/admin/allusers";
    }

    @RequestMapping("/logout")
    public String perfomLogout(){
        return "redirect:/login";
    }

}
