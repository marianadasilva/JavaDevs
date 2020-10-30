package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.User;
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
    public ResponseEntity<Actor> createNewActor(@RequestBody Actor actor) {
        Actor savedActor = service.saveActor(actor);

        return ResponseEntity.ok(savedActor);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActor() {
        return ResponseEntity.ok(service.getAllActor());
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> getActorById(@PathVariable int actorId) {
        return ResponseEntity.ok(service.getActorById(actorId));
    }

    @PutMapping("/{actorId}")
    public ResponseEntity<Actor> putTodoList(@PathVariable int actorId, @RequestBody Actor actor) {
        return ResponseEntity.ok(service.putActor(actorId, actor));
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<String> deleteActor(@PathVariable int actorId) {
        service.deleteActor(actorId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createNewActor(@RequestBody User admin) {
        User savedActor = service.save(admin);

        return ResponseEntity.ok(savedActor);
    }


}