package com.xyz.springdemo.appointmentmanagementsystem.controller;


import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService commonService;

    @GetMapping("/doctorList")
    public String doctorsList(Model model){
        List<User> user = commonService.findAllDoctors();
        model.addAttribute("users",user);
        return "admin/list";
    }

    @GetMapping("/patientList")
    public String patientLis(Model model){
        List<User> user = commonService.findAllPatients();
        model.addAttribute("users",user);
        return "admin/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("users") UserRegistrationDto user) {
            if(commonService.findRoleById(user.getUsername())!=null && commonService.findRoleById(user.getUsername()).equalsIgnoreCase("ROLE_USER")){
               commonService.savePatient(user);
               return "redirect:/admin/patientList";
            }
            commonService.saveDoctor(user);
            return "redirect:/admin/doctorList";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        commonService.deleteById(id);
        return "redirect:/admin";
    }


    @GetMapping("/update")
    public String updateUser(@RequestParam("id") int id,Model model){
        User user = commonService.findById(id);
        model.addAttribute("users",user);
        return "admin/registration";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("users",new UserRegistrationDto());
        return "admin/registration";
    }

}
