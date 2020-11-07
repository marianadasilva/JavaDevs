package com.javadevs.JavaDevs.entity;

import javax.persistence.*;


@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "genre")
    private String genre;

    @Column(name = "amount")
    private double amount;

    @OneToOne(cascade=CascadeType.ALL)
    private User user;

    public Actor(int id, String gender, String genre, double amount) {
        this.id = id;
        this.gender = gender;
        this.genre = genre;
        this.amount = amount;
    }

    public Actor() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public void setUser(User user) {
        this.user = user;
    }
}
