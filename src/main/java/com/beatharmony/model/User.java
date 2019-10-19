package com.beatharmony.model;

import java.util.ArrayList;
import java.util.List;


public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String avatar;
    private List<String> trustedUsers;
    //interest

    public User() {

    }

    public User(String id, String firstName, String lastName, String username, String email, String avatar, List<String> trustedUsers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.trustedUsers = trustedUsers;
    }

    public User(String id, String firstName, String lastName, String username, String email, String avatar) {
        this(id, firstName, lastName, username, email, avatar, new ArrayList<String>());
    }

    public User(String id, String firstName, String lastName, String username, String email) {
        this(id, firstName, lastName, username, email, null, new ArrayList<>());
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getTrustedUsers() {
        return trustedUsers;
    }

    public void setTrustedUsers(List<String> trustedUsers) {
        this.trustedUsers = trustedUsers;
    }

    public boolean addTrustedUser(String id) {
        if (trustedUsers == null) {
            this.trustedUsers = new ArrayList<>();
        }
        if (!trustedUsers.contains(id)) {
            trustedUsers.add(id);
            return true;
        }
        return false;
    }

    public boolean removeTrustedUser(String id) {
        if (trustedUsers == null) {
            this.trustedUsers = new ArrayList<>();
        }
        if (trustedUsers.contains(id)) {
            trustedUsers.remove(id);
            return true;
        }
        return false;
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
