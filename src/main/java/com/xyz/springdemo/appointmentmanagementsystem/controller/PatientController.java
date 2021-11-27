package com.xyz.springdemo.appointmentmanagementsystem.controller;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public String listPatients(Model model){
        List<User> userList = patientService.findAllPatients();
        model.addAttribute("patient",userList);
        return "patient/list-patients";
    }
    @GetMapping("/add")
    public String showFormForAdd(Model model){
        model.addAttribute("patient",new UserRegistrationDto());
        return "patient/registration";
    }
    @PostMapping("/save")
    public String registerPatientAccount(@ModelAttribute("patient") UserRegistrationDto registrationDto){
        patientService.save(registrationDto);
        return "redirect:/patient/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        patientService.deleteById(id);
        return "redirect:/patient/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") int id,Model model){
        User user = patientService.findById(id);
        model.addAttribute("patient",user);
        return "patient/registration";
    }
}
