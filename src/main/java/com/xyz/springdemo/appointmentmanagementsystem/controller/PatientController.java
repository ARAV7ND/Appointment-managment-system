package com.xyz.springdemo.appointmentmanagementsystem.controller;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.Appointment;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.service.AdminService;
import com.xyz.springdemo.appointmentmanagementsystem.service.AppointmentService;
import com.xyz.springdemo.appointmentmanagementsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/home")
    public String home(){
        return "patient/home";
    }

    @RequestMapping("/doctorList")
    public String doctor(Model model){
        List<User> user = patientService.findAllDoctors();
        model.addAttribute("users",user);
        return "patient/list";
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
    public String deletePatientAccount(@RequestParam("id") int id){
        patientService.deleteById(id);
        return "redirect:/patient/list";
    }
    @GetMapping("/update")
    public String updatePatientAccount(@RequestParam("id") int id,Model model){
        User user = patientService.findById(id);
        model.addAttribute("patient",user);
        return "patient/registration";
    }

    @GetMapping("/appointment")
    public String appointment(@RequestParam("id") int doctorId){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int tempId = 0;
        if(obj instanceof UserDetails){
            String username = ((UserDetails)obj).getUsername();
            tempId = patientService.findIdByUsername(username);
        }
        Appointment appointment = new Appointment(doctorId,tempId);
        appointmentService.save(appointment);
        return "patient/success";
    }
}
