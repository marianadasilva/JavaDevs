package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.ActorEntity;
import com.javadevs.JavaDevs.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService service;

    @PostMapping
    public ResponseEntity<ActorEntity> createNewActor(@RequestBody ActorEntity actor) {
        ActorEntity savedActor = service.saveActor(actor);

        return ResponseEntity.ok(savedActor);
    }

    @GetMapping
    public ResponseEntity<List<ActorEntity>> getAllActor() {
        return ResponseEntity.ok(service.getAllActor());
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<ActorEntity> getActorById(@PathVariable int actorId) {
        return ResponseEntity.ok(service.getActorById(actorId));
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<ActorEntity> putTodoList(@PathVariable int actorId, @RequestBody ActorEntity actor) {
        return ResponseEntity.ok(service.putActor(actorId, actor));
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<String> deleteActor(@PathVariable int actorId) {
        service.deleteActor(actorId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
