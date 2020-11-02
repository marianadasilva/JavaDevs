package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.User;
import com.javadevs.JavaDevs.repository.ActorRepository;
import com.javadevs.JavaDevs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorService {
    @Autowired
    private ActorRepository repository;

    @Autowired
    private UserRepository userRepository;

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

    public User save(User user) {
        Actor actor = new Actor();
        repository.save(actor);

        user.setActorEntity(actor);
        return userRepository.save(user);
    }
}
