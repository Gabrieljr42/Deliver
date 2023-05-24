package com.deadManWalking.userservice.controller;

import com.deadManWalking.userservice.entity.User;
import com.deadManWalking.userservice.service.UserService;

import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/users")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/register";
    }
    @GetMapping("/login")
    public String showLoginForm(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password) {

        UserDetails userDetails = userService.loadUserByUsername(username);

        if (userDetails != null) {
            return "redirect:/home";
        } else {
            return "redirect:/login?error";  
        }
    }
}