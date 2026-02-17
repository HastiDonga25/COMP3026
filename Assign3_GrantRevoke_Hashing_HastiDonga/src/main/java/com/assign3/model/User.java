package com.assign3.model;

public class User {
    private int id;
    private String username;
    private String passwordHash;
    private String mobile;
    private String email;

    public User() {}

    public User(String username, String passwordHash, String mobile, String email) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.mobile = mobile;
        this.email = email;
    }

    // getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
