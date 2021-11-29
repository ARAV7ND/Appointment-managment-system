package com.xyz.springdemo.appointmentmanagementsystem.repository;

import com.xyz.springdemo.appointmentmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    @Override
    List<User> findAll();

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id  join roles r on r.id=ur.role_id  where authority like '%DOCTOR%' ",nativeQuery = true)
    List<User> findAllDoctors();

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id  join roles r on r.id=ur.role_id  where authority like '%USER%' ",nativeQuery = true)
    List<User> findAllPatients();

    @Query(value = "select r.authority from users u join users_roles ur on u.id = ur.user_id  join roles r on r.id=ur.role_id  where u.username = ?1 ",nativeQuery = true)
    String findRoleByUsername(String username);

    @Query(value = "select id from users where username = ?1 ",nativeQuery = true)
    int findIdByUsername(String username);
}
