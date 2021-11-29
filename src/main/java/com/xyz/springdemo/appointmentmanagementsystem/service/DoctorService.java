package com.xyz.springdemo.appointmentmanagementsystem.service;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.Appointment;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    User save(UserRegistrationDto registrationDto);
    List<User> findAll();
    void deleteById(int id);
    User findById(int id);
    List<Appointment> findAllAppointmentsByDoctorId(int doctorId);

}
