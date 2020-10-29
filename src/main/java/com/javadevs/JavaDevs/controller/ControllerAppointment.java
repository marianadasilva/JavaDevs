package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.service.AppointmentService;
import com.javadevs.JavaDevs.entity.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class ControllerAppointment {

    private AppointmentService service;

    @PostMapping
    public ResponseEntity<Appointment> createNewAppointment(@RequestBody Appointment appointment ){
        Appointment savedAppointment = service.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }
}
