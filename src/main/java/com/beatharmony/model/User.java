package com.beatharmony.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private List<User> trustedUsers;
    //interest

    public User() {

    }

    public User(String id, String name, String username, String email, List<User> trustedUsers) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.trustedUsers = trustedUsers;
    }

    public User(String id, String name, String username, String email) {
        this(id, name, username, email, new ArrayList<User>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
