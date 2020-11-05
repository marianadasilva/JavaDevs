package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.dto.AppointmentRequest;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    ActorRepository actorRepository;


    public List<AppointmentRequest> saveAppointment(List<AppointmentRequest> actors) throws ParseException {
        List<AppointmentRequest> appointments = new ArrayList<>();
        for (AppointmentRequest actorRequest : actors) {
            Appointment appointment = new Appointment();
            appointment.setActor_id(actorRequest.getId());
            appointment.setDate(actorRequest.getDate());
            appointment.setStatus(true);

            Actor actor = actorRepository.findById(actorRequest.getId()).orElse(new Actor());

            appointments.add(AppointmentRequest.toDTO(appointment, actor));
            appointmentRepository.save(appointment);
        }

        return appointments;
    }

    public List<Appointment> getAllAppointment() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow();
    }

    public Appointment putAppointment(int appointmentId, Appointment appointment) {
        Appointment updateAppointment = appointmentRepository.findById(appointmentId).orElseThrow();
        updateAppointment.setStatus(appointment.isStatus());
        updateAppointment.setAmount(appointment.getAmount());
        appointmentRepository.save(updateAppointment);
        return updateAppointment;
    }

    public void deleteAppointment(int appointmentId) {
        Appointment deleteAppointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentRepository.delete(deleteAppointment);
    }
}
