package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.repository.AdminRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AdminRepository adminRepository;

    public User save(User user) {
        Admin admin = new Admin();
        adminRepository.save(admin);

        user.setAdmin(admin);
        return repository.save(user);
    }
}
