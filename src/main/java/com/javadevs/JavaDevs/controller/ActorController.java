package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.entity.ActorEntity;
import com.javadevs.JavaDevs.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService service;

//    @GetMapping
//    public ResponseEntity<Actor> getActorById(@PathVariable int actorId) {
//        return ResponseEntity.ok(service.getActorById(actorId));
//    }


    @PostMapping
    public ResponseEntity<ActorEntity> createNewActor(@RequestBody ActorEntity actor) {
        ActorEntity savedActor = service.saveActorEntity(actor);

        return ResponseEntity.ok(savedActor);
    }

//    @PutMapping
//    public ResponseEntity<Actor> updateActor(@PathVariable int ActorId, @RequestBody TodoList todoList) {
//        return ResponseEntity.ok(service.putActor(actortId, actor));
//    }
//
//    @DeleteMapping
//    public ResponseEntity<int> deleteActor(@PathVariable int actorId) {
//        service.deleteActor(actorId);
//        return new ResponseEntity<>("", HttpStatus.OK);
//
//    }

}
