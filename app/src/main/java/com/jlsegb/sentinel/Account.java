package com.jlsegb.sentinel;

public class Account {

    public Profile profile;
    public SwipeHistory swipeHistory;
    public RecoveryQA recoveryQA;

    private String id;
    private String username;
    private String password;
    private String email;
    private boolean isNewUser;

// Accessors and Mutators
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsNewUser() {
        return isNewUser;
    }

    public void setIsnewUser(boolean newUser) {
        isNewUser = newUser;
    }
}
