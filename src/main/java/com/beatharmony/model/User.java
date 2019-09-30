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
    private List<User> trustedUsers;
    //interest

    public User() {

    }

    public User(String id, String firstName, String lastName, String username, String email, List<User> trustedUsers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.trustedUsers = trustedUsers;
    }

    public User(String id, String firstName, String lastName, String username, String email) {
        this(id, firstName, lastName, username, email, new ArrayList<User>());
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

    public List<User> getTrustedUsers() {
        return trustedUsers;
    }

    public void setTrustedUsers(List<User> trustedUsers) {
        this.trustedUsers = trustedUsers;
    }

    public void addTrustedUser(User trustedUser) {
        trustedUsers.add(trustedUser);
    }
}
