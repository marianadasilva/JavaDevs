package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.AppointmentResponse;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointment() {
        return ResponseEntity.ok(service.getAllAppointment());
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable int appointmentId) {
        return ResponseEntity.ok(service.getAppointmentById(appointmentId));
    }

    @GetMapping("/actor/{actor_id}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentByActor(@PathVariable int actor_id) {
        return ResponseEntity.ok(service.getAppointmentActorById(actor_id));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment appointment) {
        return ResponseEntity.ok(service.putAppointment(appointmentId, appointment));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId) {
        service.deleteAppointment(appointmentId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }


}
