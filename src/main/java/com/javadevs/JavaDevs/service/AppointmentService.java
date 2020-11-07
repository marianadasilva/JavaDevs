package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.dto.AppointmentRequest;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.dto.AppointmentResponse;
import com.javadevs.JavaDevs.dto.UserRegistrationActorDTO;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ActorInvalidRequest;
import com.javadevs.JavaDevs.exception.AppointmentNotExists;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ActorRepository actorRepository;
    private final UserRepository userRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, ActorRepository actorRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.actorRepository = actorRepository;
        this.userRepository = userRepository;
    }

    public List<AppointmentResponse> saveAppointment(List<AppointmentRequest> actors) throws ParseException {
        List<AppointmentResponse> appointments = new ArrayList<>();
        for (AppointmentRequest actorRequest : actors) {
            if (!verifyAppointmentExists(actorRequest)) continue; //throw new AppointmentExists();

            var userObject= userRepository.findAllActorUserById(actorRequest.getActor_id());

            if (userObject.size() <= 0) continue;

            User user = new User();

            userObject.forEach(result -> {
                user.setId((int) result[0]);
                user.setName((String) result[1]);
                user.setEmail((String) result[2]);
            });

            Actor actor = actorRepository.findById(actorRequest.getActor_id()).orElseThrow(ActorInvalidRequest::new);

            if (actor.getGender() == null || actor.getGenre() == null || actor.getAmount() <= 0) {
                throw new ActorInvalidRequest();
            }

            Appointment appointment = new Appointment();
            appointment.setActor_id(actorRequest.getActor_id());
            appointment.setDate(actorRequest.getDate());
            appointment.setStatus(true);
            appointment.setAmount(actor.getAmount());

            var newAppointment = appointmentRepository.save(appointment);
            user.setActor(actor);

            newAppointment.setUser(UserRegistrationActorDTO.toDTO(user));
            appointments.add(AppointmentResponse.toDTO(newAppointment));
        }

        return appointments;
    }

    private boolean verifyAppointmentExists (AppointmentRequest appointment) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

        var appointmentExists = appointmentRepository.verifyAppointmentExists(appointment.getActor_id(), true, formatDate.parse(appointment.getDate()));

        return appointmentExists == null;
    }

    public List<AppointmentResponse> getAllAppointment() {
        List<AppointmentResponse> appointmentsResponse = new ArrayList<>();

        var appointments= (List<Appointment>) appointmentRepository.findAll();
        var users = userRepository.findAllActorUser();

        User user = new User();

        for (Appointment appointment : appointments) {
            users.forEach(result -> {
                int actor_id = (int) result[3];
                if (actor_id == appointment.getActor_id()) {
                    String gender = (String) result[4];
                    String genre = (String) result[5];
                    double amount = (double) result[6];

                    user.setId((int) result[0]);
                    user.setName((String) result[1]);
                    user.setEmail((String) result[2]);
                    user.setActor(new Actor(actor_id, gender, genre, amount));
                    appointment.setUser(UserRegistrationActorDTO.toDTO(user));

                    appointmentsResponse.add(AppointmentResponse.toDTO(appointment));
                }
            });
        }

        return appointmentsResponse;
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId).orElseThrow();
    }

    public AppointmentResponse putAppointment(int appointmentId, Appointment appointment) {
        Appointment updateAppointment = appointmentRepository.findById(appointmentId).orElseThrow(AppointmentNotExists::new);
        updateAppointment.setStatus(appointment.isStatus());

        if (appointment.getAmount() > 0) {
            updateAppointment.setAmount(appointment.getAmount());
        }

        updateAppointment.setDate(appointment.getDate());

        var appointmentSaved = appointmentRepository.save(updateAppointment);
        var actorByUser = userRepository.findAllActorUserById(appointmentSaved.getActor_id());

        actorByUser.forEach(result -> {
            int userId = (int) result[0];
            int actorId = (int) result[3];
            var user = userRepository.findById(userId).orElseThrow();
            var actor = actorRepository.findById(actorId).orElseThrow();

            user.setActor(actor);

            appointmentSaved.setUser(UserRegistrationActorDTO.toDTO(user));
        });

        return AppointmentResponse.toDTO(appointmentSaved);
    }

    public void deleteAppointment(int appointmentId) {
        Appointment deleteAppointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentRepository.delete(deleteAppointment);
    }
}
