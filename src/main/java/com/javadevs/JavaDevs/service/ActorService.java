package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.dto.UserRegistrationActorDTO;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.exception.ActorInvalidRequest;
import com.javadevs.JavaDevs.exception.AppointmentExistToActor;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.AppointmentRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActorService {

    private final ActorRepository repository;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public ActorService(ActorRepository repository, AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.repository = repository;
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public List<UserRegistrationActorDTO> getAllActor() {
        List<UserRegistrationActorDTO> actors = new ArrayList<>();
        var users = userRepository.findAllActorUser();

        users.forEach(result -> {
            int id = (int) result[0];
            String name = (String) result[1];
            String email = (String) result[2];
            User user = new User(id, name, email);

            int actor_id = (int) result[3];
            String gender = (String) result[4];
            String genre = (String) result[5];
            double amount = (double) result[6];

            Actor actor = new Actor(actor_id, gender, genre, amount);

            user.setActor(actor);

            actors.add(UserRegistrationActorDTO.toDTO(user));
        });

        return actors;
    }

    public UserRegistrationActorDTO getActorById(int actorId) {
        var users = userRepository.findAllActorUserById(actorId);

        if (users.size() <= 0) {
            throw new ActorInvalidRequest();
        }

        User user = new User();

        users.forEach(result -> {
            int id = (int) result[0];
            String name = (String) result[1];
            String email = (String) result[2];
            user.setId(id);
            user.setName(name);
            user.setEmail(email);

            int actor_id = (int) result[3];
            String gender = (String) result[4];
            String genre = (String) result[5];
            double amount = (double) result[6];

            Actor actor = new Actor(actor_id, gender, genre, amount);

            user.setActor(actor);
        });

        return UserRegistrationActorDTO.toDTO(user);
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