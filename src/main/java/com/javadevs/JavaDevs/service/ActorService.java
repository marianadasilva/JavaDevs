package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.exception.ActorInvalidRequest;
import com.javadevs.JavaDevs.exception.AppointmentExistToActor;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ActorService {

    private final ActorRepository repository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public ActorService(ActorRepository repository, AppointmentRepository appointmentRepository) {
        this.repository = repository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<Actor> getAllActor() {
        return (List<Actor>) repository.findAll();
    }

    public Actor getActorById(int actorId) {
        return repository.findById(actorId).orElseThrow(ActorInvalidRequest::new);
    }

    public Actor putActor(int actorId, Actor actor) {
        Actor updateActor = repository.findById(actorId).orElseThrow(ActorInvalidRequest::new);
        updateActor.setAmount(actor.getAmount());
        updateActor.setGender(actor.getGender());
        updateActor.setGenre(actor.getGenre());
        repository.save(updateActor);
        return updateActor;
    }

    public void deleteActor(int actorId) {
        Actor deleteActor = repository.findById(actorId).orElseThrow(ActorInvalidRequest::new);
        var appointmentCount = appointmentRepository.verifyAppointmentExistsToActor(actorId);

        if (appointmentCount > 0) {
            throw new AppointmentExistToActor();
        }

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