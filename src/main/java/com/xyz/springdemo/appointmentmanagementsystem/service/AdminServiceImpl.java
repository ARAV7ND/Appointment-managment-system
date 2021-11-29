package com.xyz.springdemo.appointmentmanagementsystem.service;

import com.xyz.springdemo.appointmentmanagementsystem.dto.UserRegistrationDto;
import com.xyz.springdemo.appointmentmanagementsystem.entity.Role;
import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import com.xyz.springdemo.appointmentmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository repository;


    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        Optional<User> result = repository.findById(id);
        User user = null;
        if(result.isPresent()){
            user = result.get();
        }else{
            throw new RuntimeException("404.!! User not Found");
        }
        return user;
    }


    @Override
    public User saveDoctor(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getUsername(),
                                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_DOCTOR",registrationDto.getUsername())));

        user.setId(registrationDto.getId());
        return repository.save(user);
    }

    @Override
    public User savePatient(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getUsername(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER",registrationDto.getUsername())));

        user.setId(registrationDto.getId());
        return repository.save(user);
    }
    @Override
    public List<User> findAllDoctors() {
        List<User> doctorList = repository.findAllDoctors();
        return doctorList;
    }

    @Override
    public List<User> findAllPatients() {
        List<User> patientList = repository.findAllPatients();
        return patientList;
    }
    public String findRoleById(String username){
        return repository.findRoleByUsername(username);
    }
}
