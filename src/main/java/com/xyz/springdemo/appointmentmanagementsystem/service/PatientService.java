package com.xyz.springdemo.appointmentmanagementsystem.service;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;

import java.util.List;

public interface PatientService {
    User save(UserRegistrationDto registrationDto);
    List<User> findAll();
    void deleteById(int id);
    User findById(int id);
    List<User> findAllDoctors();
    int findIdByUsername(String username);
}
