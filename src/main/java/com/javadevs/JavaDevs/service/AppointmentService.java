package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;


    public Appointment saveAppointment(Appointment appointment){
        return repository.save(appointment);
    }

    public List<Appointment> getAllAppointment() {
        return (List<Appointment>) repository.findAll();
    }

    public Appointment getAppointmentById(int appointmentId) {
        return repository.findById(appointmentId).orElseThrow();
    }

    public Appointment putAppointment(int appointmentId, Appointment appointment) {
        Appointment updateAppointment = repository.findById(appointmentId).orElseThrow();
        updateAppointment.setStatus(appointment.isStatus());
        updateAppointment.setDate((Timestamp) appointment.getDate());
        updateAppointment.setAmount(appointment.getAmount());
        repository.save(updateAppointment);
        return updateAppointment;
    }

    public void deleteAppointment(int appointmentId) {
        Appointment deleteAppointment = repository.findById(appointmentId).orElseThrow();
        repository.delete(deleteAppointment);
    }
}
