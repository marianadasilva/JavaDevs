package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.ActorEntity;
import com.javadevs.JavaDevs.service.AppointmentService;
import com.javadevs.JavaDevs.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<Appointment> createNewAppointment(@RequestBody Appointment appointment ){
        Appointment savedAppointment = service.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        return ResponseEntity.ok(service.getAllAppointment());
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getActorById(@PathVariable int appointmentId) {
        return ResponseEntity.ok(service.getAppointmentById(appointmentId));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<Appointment> putTodoList(@PathVariable int appointmentId, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.putAppointment(appointmentId, appointment));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId) {
        service.deleteAppointment(appointmentId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
