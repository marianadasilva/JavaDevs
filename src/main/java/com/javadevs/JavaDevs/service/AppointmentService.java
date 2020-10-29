package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;


    public Appointment saveAppointment(Appointment appointment){
        return repository.save(appointment);
    }
}
