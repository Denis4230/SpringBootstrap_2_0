package com.example.web.springbootstrap2_0.contriller;

import com.example.web.springbootstrap2_0.model.User;
import com.example.web.springbootstrap2_0.service.RoleService;
import com.example.web.springbootstrap2_0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String findAll(@AuthenticationPrincipal UserDetails userDetails,
                          Model model){
        model.addAttribute("listRole", roleService.findAll());
        model.addAttribute("user", userService.findByUserName(userDetails.getUsername()));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user")User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
