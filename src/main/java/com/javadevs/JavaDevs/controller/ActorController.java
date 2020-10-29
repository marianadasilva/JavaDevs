package com.javadevs.JavaDevs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorController service;

    @GetMapping("/{actorId}")
    public ResponseEntity<Actor> getActorById(@PathVariable int actorId) {
        return ResponseEntity.ok(service.getActorById(actorId));
    }


    @PostMapping
    public ResponseEntity<Actor> createnewActor(@RequestBody Actor actor) {
        Actor savedActor = service.saveActor(actor);

        return ResponseEntity.ok(savedActor);
    }

    @PutMapping("/{Actor}")
    public ResponseEntity<Actor> updateActor(@PathVariable int ActorId, @RequestBody TodoList todoList) {
        return ResponseEntity.ok(service.putActor(actortId, actor));
    }

    @DeleteMapping("/{ActorId}")
    public ResponseEntity<int> deleteActor(@PathVariable int actorId) {
        service.deleteActor(actorId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
