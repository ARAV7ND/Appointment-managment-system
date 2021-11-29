package com.xyz.springdemo.appointmentmanagementsystem.service;

import com.xyz.springdemo.appointmentmanagementsystem.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    List<Appointment> findAllById(int id);

}
