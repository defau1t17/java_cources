package by.spring.Controller;

import by.spring.entity.Address;
import by.spring.entity.User;
import by.spring.model.RegistrationModel;
import by.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("newUser", new RegistrationModel());
        return "reg";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newUser") RegistrationModel user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            List<FieldError> fieldErrors = new ArrayList<>();
//            for (FieldError fieldError : fieldErrors) {
//                errors.put(fieldError.getObjectName(), fieldError.getDefaultMessage());
//
//            }
////
//            model.addAllAttributes(errors);
            return "reg";
        }

        User us = new User();
        us.setName(user.getName());
        us.setUsername(user.getUsername());
        us.setPassword(user.getPassword());
        us.setAddress(new Address(0,user.getCity(),user.getStreet()));


        userService.save(us);
        return "redirect:/";
    }

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(RuntimeException e) {

        return "error";
    }
}
