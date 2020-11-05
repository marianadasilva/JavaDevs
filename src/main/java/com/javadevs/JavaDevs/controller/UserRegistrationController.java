package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.UserAuthenticateAdminDTO;
import com.javadevs.JavaDevs.dto.UserAuthenticateDTO;
import com.javadevs.JavaDevs.dto.UserRegistrationActorDTO;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController() {

    }

    @PostMapping("/actor/signup")
    public ResponseEntity<UserRegistrationActorDTO> createActor(@RequestBody User userRegistration) {
        User user = userRegistrationService.registerActor(userRegistration);
        return new ResponseEntity<>(UserRegistrationActorDTO.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<UserAuthenticateAdminDTO> createAdmin(@RequestBody User userRegistration) {
        User user = userRegistrationService.registerAdmin(userRegistration);
        return new ResponseEntity<>(UserAuthenticateAdminDTO.toDTO(user), HttpStatus.CREATED);
    }

}
