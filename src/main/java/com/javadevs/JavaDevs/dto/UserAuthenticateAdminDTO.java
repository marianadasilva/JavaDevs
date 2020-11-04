package com.javadevs.JavaDevs.dto;


import com.javadevs.JavaDevs.entity.Admin;
import com.javadevs.JavaDevs.entity.User;

public class UserAuthenticateAdminDTO {

    private int id;
    private String name;
    private String email;
    private Admin admin;

    public UserAuthenticateAdminDTO() {
    }

    public UserAuthenticateAdminDTO(int id, String name, String email, Admin admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public static UserAuthenticateAdminDTO toDTO(User user) {
        return new UserAuthenticateAdminDTO(user.getId(), user.getName(), user.getEmail(), user.getAdmin());
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
