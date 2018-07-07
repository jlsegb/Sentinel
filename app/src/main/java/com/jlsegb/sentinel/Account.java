package com.jlsegb.sentinel;

public class Account {

    public Profile profile;
    public SwipeHistory swipeHistory;
    public RecoveryQA recoveryQA;

    private String id;
    private String email;
    private boolean isNewUser;

// Accessors and Mutators
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
