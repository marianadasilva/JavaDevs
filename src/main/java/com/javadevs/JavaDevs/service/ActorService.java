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
}
