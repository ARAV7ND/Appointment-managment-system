package com.xyz.springdemo.appointmentmanagementsystem.controller;

import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home(Model model,Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user",user);
       return "patient/home";
    }
    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user",user);
        return "admin/home";
    }
    @GetMapping("/doctor")
    public String doctor(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user",user);
        return "doctor/home";
    }
    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("user",user);
        return "patient/home";
    }


}
