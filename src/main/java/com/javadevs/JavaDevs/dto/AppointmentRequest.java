package com.javadevs.JavaDevs.dto;

import com.javadevs.JavaDevs.entity.Actor;
import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.Appointment;
import com.javadevs.JavaDevs.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentRequest {

    private int id;
    private String gender;
    private String genre;
    private double amount;
    private String date;
    private boolean status;

    public AppointmentRequest(int id, String gender, String genre, double amount, boolean status, String date) {
        this.id = id;
        this.gender = gender;
        this.genre = genre;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public AppointmentRequest() {
    }

    public static AppointmentRequest toDTO(Appointment appointment, Actor actor) {
        Date date = appointment.getDate();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);

        return new AppointmentRequest(actor.getId(), actor.getGender(), actor.getGenre(),
                actor.getAmount(), appointment.isStatus(), strDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
}
