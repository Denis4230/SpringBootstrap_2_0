package com.example.web.springbootstrap2_0.contriller;

import com.example.web.springbootstrap2_0.model.User;
import com.example.web.springbootstrap2_0.service.UserService;
import com.example.web.springbootstrap2_0.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;

@Controller
public class UserController1 {

    private final UserService userService;
    @Autowired
    public UserController1(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @GetMapping("/admin")
//    public String findAll(Model model){
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "user-list";
//    }



//    @GetMapping("admin/user-create")
//    public String createUserForm(Model model){
//        model.addAttribute("user", new User());
//        return "user-create";
//
//    }
//    @PostMapping("admin/user-create")
//    public String createUser( @ModelAttribute("user")User user,
//                              @ModelAttribute("role") String[] role){
//        userService.saveUser(user, role);
//        return "redirect:/admin";
//    }



//    @GetMapping("/user")
//    public String userPage(Principal principal, Model model) {
//        model.addAttribute("user", userService.findByUserName(principal.getName()));
//        return "user1";
//    }
    @GetMapping("/admin/info")
    public String adminPage(Principal principal, Model model) {
        model.addAttribute("user",
                userService.findByUserName(principal.getName()));
        return "admin-info";
    }


//    @GetMapping("/admin/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, Model model){
//        model.addAttribute("user", userService.findById(id));
//        return "user-update";
//    }
//    @PostMapping("/admin/user-update")
//    public String updateUser(@ModelAttribute("user") User user,
//                             @ModelAttribute("role")String[] roles){
//        userService.saveUser(user, roles);
//        return "redirect:/admin";
//    }



//    @GetMapping("admin/user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.deleteById(id);
//        return "redirect:/admin";
//    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

}

