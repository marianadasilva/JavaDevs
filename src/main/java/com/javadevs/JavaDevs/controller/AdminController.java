package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/signup")
    public ResponseEntity<User> createNewActor(@RequestBody User admin) {
        User savedAdmin = service.save(admin);

        return ResponseEntity.ok(savedAdmin);
    }

}
