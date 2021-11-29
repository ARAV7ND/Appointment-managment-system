package com.xyz.springdemo.appointmentmanagementsystem.repository;

import com.xyz.springdemo.appointmentmanagementsystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Override
    List<Appointment> findAll();

    @Query(value = "select * from appointment where doctor_id = ?1",nativeQuery = true)
    List<Appointment> findAllById(int doctorId);



}
