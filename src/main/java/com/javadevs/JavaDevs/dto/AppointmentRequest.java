package com.javadevs.JavaDevs.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentRequest {

    private int id;
    private int actor_id;
    private String name;
    private String email;
    private String date;
    private boolean status;
    private Actor actor;

    @JsonIgnore
    private double amount;

    public AppointmentRequest(int id, int actor_id, String name, String email,
                              boolean status, String date, Actor actor) {
        this.id = id;
        this.actor_id = actor_id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.status = status;
        this.actor = actor;
    }

    public static AppointmentRequest toDTO(Appointment appointment, Actor actor, User user) {
        Date date = appointment.getDate();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);

        return new AppointmentRequest(appointment.getId(), actor.getId(), user.getName(), user.getEmail(),
                appointment.isStatus(), strDate, actor);
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}