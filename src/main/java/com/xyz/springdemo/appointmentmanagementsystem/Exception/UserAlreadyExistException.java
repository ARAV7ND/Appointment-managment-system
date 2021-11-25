package com.xyz.springdemo.appointmentmanagementsystem.Exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
