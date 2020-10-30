package com.javadevs.JavaDevs.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private double maxAmount;

    @Column(nullable = false, name = "maxAmount")
    public double getMaxAmount() {
        return maxAmount;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

}
