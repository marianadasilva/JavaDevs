package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class ActorService {

    private ActorRepository repository;
    private UserRepository userRepository;
    private AppointmentRepository appointmentRepository;

    @Autowired
    public ActorService(ActorRepository repository, UserRepository userRepository, AppointmentRepository appointmentRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Actor saveActor(Actor actor) {
        return repository.save(actor);
    }

    public List<Actor> getAllActor() {
        return (List<Actor>) repository.findAll();
    }

    public Actor getActorById(int actorId) {
        return repository.findById(actorId).orElseThrow();
    }

    public Actor putActor(int actorId, Actor actor) {
        Actor updateActor = repository.findById(actorId).orElseThrow();
        updateActor.setAmount(actor.getAmount());
        updateActor.setGender(actor.getGender());
        repository.save(updateActor);
        return updateActor;
    }

    public void deleteActor(int actorId) {
        Actor deleteActor = repository.findById(actorId).orElseThrow();
        repository.delete(deleteActor);
    }

    public List<Actor> search(int quantity, String genre, double amount, String date) {
        List<Actor> search = repository.findAllActor(amount, quantity, genre);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate data = LocalDate.parse(date, formatter);

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        appointments.forEach(appointment -> {
            String strDate = dateFormat.format(appointment.getDate());
            LocalDate dataAppointment = LocalDate.parse(strDate, formatter);

            search.removeIf(actor -> (actor.getId() == appointment.getActor_id() && appointment.isStatus() && dataAppointment.isEqual(data)));
        });

        return search;
    }
}
