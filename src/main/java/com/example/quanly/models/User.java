package com.example.quanly.models;

public class User {
    private int ID;
    private String username;
    private String password;
    private int role;

    public User(int ID, String username, String password, int role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
