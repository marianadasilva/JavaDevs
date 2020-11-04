package com.javadevs.JavaDevs.dto;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.User;

public class UserRegistrationActorDTO {

    private int id;
    private String name;
    private String email;
    private Actor actor;

    public UserRegistrationActorDTO(int id, String name, String email, Actor actor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.actor = actor;
    }

    public UserRegistrationActorDTO() {
    }

    public static UserRegistrationActorDTO toDTO(User user) {
        return new UserRegistrationActorDTO(user.getId(), user.getName(), user.getEmail(), user.getActor());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
