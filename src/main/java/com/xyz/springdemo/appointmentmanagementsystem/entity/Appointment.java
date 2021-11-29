package com.xyz.springdemo.appointmentmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "user_id")
    private int userId;

    public Appointment() {
    }

    public Appointment(int doctorId, int userId) {
        this.doctorId = doctorId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
