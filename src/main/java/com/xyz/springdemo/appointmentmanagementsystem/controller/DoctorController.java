package com.xyz.springdemo.appointmentmanagementsystem.controller;

import com.xyz.springdemo.appointmentmanagementsystem.entity.Appointment;
import com.xyz.springdemo.appointmentmanagementsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController   {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/appointmentList")
    public String showAppointments(@RequestParam("id") int id,Model model){
        List<Appointment> appointmentList = doctorService.findAllAppointmentsByDoctorId(id);
        model.addAttribute("appointmentList",appointmentList);
        return "doctor/list";
    }

//    @GetMapping("/list")
//    public String listDoctors(Model model){
//        List<User> userList = doctorService.findAll();
//        model.addAttribute("doctors",userList);
//        return "doctor/list-doctors";
//    }
//    @GetMapping("/add")
//    public String showFormForAdd(Model model){
//        model.addAttribute("doctors",new UserRegistrationDto());
//        return "doctor/registration";
//    }
//    @PostMapping("/save")
//    public String registerDoctorAccount(@ModelAttribute("doctors") UserRegistrationDto registrationDto){
//        doctorService.save(registrationDto);
//        return "redirect:/doc/list";
//    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id") int id){
//        doctorService.deleteById(id);
//        return "redirect:/doc/list";
//    }
//    @GetMapping("/update")
//    public String update(@RequestParam("id") int id,Model model){
//        User user = doctorService.findById(id);
//        model.addAttribute("doctors",user);
//        return "doctor/registration";
//    }

}
