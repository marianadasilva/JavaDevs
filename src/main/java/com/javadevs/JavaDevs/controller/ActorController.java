package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.dto.UserRegistrationActorDTO;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    private ActorService service;

    @GetMapping
    public ResponseEntity<List<UserRegistrationActorDTO>> getAllActor() {
        return ResponseEntity.ok(service.getAllActor());
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<UserRegistrationActorDTO> getActorById(@PathVariable int actorId) {
        return ResponseEntity.ok(service.getActorById(actorId));
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> updateActor(@PathVariable int actorId, @RequestBody Actor actor) {
        return ResponseEntity.ok(service.putActor(actorId, actor));
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<String> deleteActor(@PathVariable int actorId) {
        service.deleteActor(actorId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}