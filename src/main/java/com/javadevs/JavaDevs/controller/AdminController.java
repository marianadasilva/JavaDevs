package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.AppointmentRequest;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ExpiredTokenException;
import com.javadevs.JavaDevs.exception.InvalidTokenException;
import com.javadevs.JavaDevs.service.*;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
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

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getAllActor(@RequestAttribute("idUser") Integer actorId) {
        return ResponseEntity.ok(actorService.getAllActor());
    }

    @PostMapping("/appointment")
    public ResponseEntity<List<AppointmentRequest>> createNewAppointment(@RequestBody List<AppointmentRequest> appointment) throws ParseException {
        List<AppointmentRequest> savedAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
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
