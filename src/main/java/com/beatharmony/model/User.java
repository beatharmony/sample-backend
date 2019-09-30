package com.beatharmony.model;

import com.sun.media.sound.SF2InstrumentRegion;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private List<String> trustedUsers;
    //interest

    public User() {

    }

    public User(String id, String firstName, String lastName, String username, String email, List<String> trustedUsers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.trustedUsers = trustedUsers;
    }

    public User(String id, String firstName, String lastName, String username, String email) {
        this(id, firstName, lastName, username, email, new ArrayList<String>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTrustedUsers() {
        return trustedUsers;
    }

    public void setTrustedUsers(List<String> trustedUsers) {
        this.trustedUsers = trustedUsers;
    }

    public void addTrustedUser(String id) {
        if (trustedUsers == null) {
            this.trustedUsers = new ArrayList<>();
        }
        if (!trustedUsers.contains(id)) {
            trustedUsers.add(id);
        }
    }
    public void removeTrustedUser(String id) {
        if (trustedUsers == null) {
            this.trustedUsers = new ArrayList<>();
        }
        if (trustedUsers.contains(id)) {
            trustedUsers.remove(id);
        }
    }

    @Override
    public boolean equals(Object o) {
        User other = (User) o;
        if (this.id.equals(other.getId())) {
            return true;
        }
        return false;
    }
}
