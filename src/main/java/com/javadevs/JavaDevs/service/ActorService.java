package com.javadevs.JavaDevs.service;

import com.javadevs.JavaDevs.entity.ActorEntity;
import org.springframework.stereotype.Component;

@Component
public class ActorService {

    public ActorEntity saveActorEntity(ActorEntity actor) {
        return repository.save(actor);
    }

}
