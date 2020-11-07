package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.AppointmentRequest;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.dto.AppointmentResponse;
import com.javadevs.JavaDevs.service.ActorService;
import com.javadevs.JavaDevs.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ActorService actorService;
    private final AppointmentService appointmentService;

    @Autowired
    public AdminController(ActorService actorService, AppointmentService appointmentService) {
        this.actorService = actorService;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<List<AppointmentResponse>> createNewAppointment(@RequestBody List<AppointmentRequest> appointment) throws ParseException {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Actor>> search(
            @RequestParam("genre") String genre,
            @RequestParam("amount") double amount,
            @RequestParam("quantity") int quantity,
            @RequestParam("date") String date) {
        return ResponseEntity.ok(actorService.search(quantity, genre, amount, date));
    }
}
