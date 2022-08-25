package com.example.web.springbootstrap2_0.contriller;

import com.example.web.springbootstrap2_0.model.User;
import com.example.web.springbootstrap2_0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String findAll(@AuthenticationPrincipal UserDetails userDetails,
                          Model model){
        model.addAttribute("user", userService.findByUserName(userDetails.getUsername()));
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/admin/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @ModelAttribute("role")String[] roles){
        userService.saveUser(user, roles);
        return "redirect:/admin";
    }

    @PostMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("admin/add")
    public String createUser( @ModelAttribute("user")User user,
                              @ModelAttribute("role") String[] role){
        userService.saveUser(user, role);
        return "redirect:/admin";
    }
}
