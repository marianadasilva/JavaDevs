package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.ActorEntity;
import com.javadevs.JavaDevs.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorService {
    @Autowired
    private ActorRepository repository;

    public ActorEntity saveActor(ActorEntity actor) {
        return repository.save(actor);
    }

    public List<ActorEntity> getAllActor() {
        return (List<ActorEntity>) repository.findAll();
    }

    public ActorEntity getActorById(int actorId) {
        return repository.findById(actorId).orElseThrow();
    }

    public ActorEntity putActor(int actorId, ActorEntity actor) {
        ActorEntity updateActor = repository.findById(actorId).orElseThrow();
        updateActor.setAmount(actor.getAmount());
        updateActor.setGender(actor.getGender());
        repository.save(updateActor);
        return updateActor;
    }

    public void deleteActor(int actorId) {
        ActorEntity deleteActor = repository.findById(actorId).orElseThrow();
        repository.delete(deleteActor);
    }
}
