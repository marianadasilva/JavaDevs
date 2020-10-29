package com.javadevs.JavaDevs.controller;

import com.javadevs.JavaDevs.JavaDevsApplication;
import com.javadevs.JavaDevs.entity.ActorEntity;
import com.javadevs.JavaDevs.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService service;

    @PostMapping("/create")
    public ResponseEntity<ActorEntity> createNewActor(@RequestBody ActorEntity actor) {
        ActorEntity savedActor = service.saveActor(actor);

        return ResponseEntity.ok(savedActor);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ActorEntity>> getAllActor() {
        return ResponseEntity.ok(service.getAllActor());
    }
}
