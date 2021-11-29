package com.xyz.springdemo.appointmentmanagementsystem.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class UserRegistrationDto {

    private int id;

    @NotEmpty(message = "is required")
    private String firstName;

    @NotEmpty(message = "is required")
    private String lastName;

    @Email(message = "invalid email")
    private String username;

    @NotEmpty(message = "is required")
    private String password;


    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
