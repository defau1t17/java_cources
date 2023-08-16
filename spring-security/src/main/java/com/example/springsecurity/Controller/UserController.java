package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.User;
import com.example.springsecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(User user) {
        service.registration(user);
        return "redirect:/home";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
