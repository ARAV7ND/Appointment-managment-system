package com.xyz.springdemo.appointmentmanagementsystem.service;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;

import java.util.List;

public interface AdminService {
//    User save(UserRegistrationDto registrationDto);
    User saveDoctor(UserRegistrationDto registrationDto);
    User savePatient(UserRegistrationDto registrationDto);
    List<User> findAllDoctors();
    List<User> findAllPatients();
    void deleteById(int id);
    User findById(int id);
    String findRoleById(String username);
}
