package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.UserAuthenticateDTO;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticateDTO> authenticate(@RequestBody User userRegistration, HttpServletResponse response) {
        User user = userRegistrationService.register(userRegistration, response);
        return new ResponseEntity<>(UserAuthenticateDTO.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> unregister(HttpServletRequest request, HttpServletResponse response) {
        userRegistrationService.unregister(request, response);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
