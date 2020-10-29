package com.javadevs.JavaDevs.entity;

import javax.persistence.Column;

public class Admin {
    private double maxAmount;

    @Column(name = "maxAmount")
    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }
}
