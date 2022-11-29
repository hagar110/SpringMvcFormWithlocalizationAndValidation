package com.vodafone.controller;

import com.vodafone.model.User;
import com.vodafone.service.UserService;
import com.vodafone.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/users")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration" )
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid  @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> model = bindingResult.getModel();
            System.out.println(model);
            return "registration";
        }
        System.out.println("prrrrrrrrrrrrrrrrriiiiintttttt!!!!!!!!!!");
        System.out.println(user);
        userService.save(user);
        return "redirect:/users/users";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        System.out.println("in user serviceee!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
