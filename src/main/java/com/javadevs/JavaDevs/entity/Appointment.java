package com.javadevs.JavaDevs.entity;

import com.javadevs.JavaDevs.dto.UserRegistrationActorDTO;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "actor_id")
    private int actor_id;

    @Transient
    private UserRegistrationActorDTO user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateTime) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        this.date = formatDate.parse(dateTime);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public UserRegistrationActorDTO getUser() {
        return user;
    }

    public void setUser(UserRegistrationActorDTO user) {
        this.user = user;
    }
}
