package com.javadevs.JavaDevs.entity;

import java.util.List;

public class ActorEntity {
    private String gender;
    private double amout;
    private List<String> habilities;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    public List<String> getHabilities() {
        return habilities;
    }

    public void setHabilities(List<String> habilities) {
        this.habilities = habilities;
    }
}
