// package com.deadManWalking.DeliverApp.Controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class UserController {
//     @GetMapping("/hello/{name}")
//     public String hello(@PathVariable String name) {
//         return "Hello, " + name + " from your-microservice-name!";
//     }
//     @GetMapping("/")
//     public String home() {
//         return "Welcome to your-microservice-name!";
//     }
// }
package com.deadManWalking.DeliverApp.Controller;

import com.deadManWalking.DeliverApp.Model.User;
import com.deadManWalking.DeliverApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}