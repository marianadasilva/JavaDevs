package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.UserAuthenticateDTO;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.service.UserAuthenticationService;
import com.javadevs.JavaDevs.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public AuthenticationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    public AuthenticationController() {
    }

    @PostMapping
    public ResponseEntity<UserAuthenticateDTO> authenticate(@RequestBody User userRegistration, HttpServletResponse response) {
        User user = userRegistrationService.registrate(userRegistration, response);
        return new ResponseEntity<UserAuthenticateDTO>(UserAuthenticateDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }
}
