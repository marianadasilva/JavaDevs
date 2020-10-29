package com.javadevs.JavaDevs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ActorEntity {

    @Column(name = "gender")
    private String gender;

    @Column(name = "amount")
    private double amount;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
