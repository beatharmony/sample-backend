package com.beatharmony.service;

import com.beatharmony.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    private User rishma = new User("2", "Rishma", "Mendhekar", "rmendhekar", "rishma@gmail.com", (List<User>) null);
    private User ankit = new User("3", "Ankit", "Verma", "averma", "ankit@gmail.com", (List<User>) null);
    private User pradyumna = new User("4", "Pradyumna", "Mukunda", "pmukunda", "pradyumna@gmail.com", (List<User>) null);
    private User christian = new User("5", "Christian", "Graham", "cgraham", "christian@gmail.com", (List<User>) null);

    List<User> trusted = new ArrayList<>(Arrays.asList(rishma, ankit, pradyumna, christian));
    private User justin = new User("1", "Justin", "Higgins", "jhiggins", "just1higg@gmail.com", trusted);

    private List<User> users = new ArrayList<>(Arrays.asList(justin, rishma, ankit, pradyumna, christian));

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsersByName(String name) {
        String[] parts = name.split(" ");
        List<User> resultList = new ArrayList<>();
        //this means only a first or last was entered
        if (parts.length == 1) {
            List<User> firstResults = getUsersByFirstName(parts[0]);
            List<User> lastResults = getUsersByLastName(parts[0]);
            for (User user : firstResults) {
                resultList.add(user);
            }
            for (User user : lastResults) {
                if (!resultList.contains(user)) {
                    resultList.add(user);
                }
            }
        } else if (parts.length == 2) {
            for (User user : users) {
                if (user.getFirstName().equals(parts[0]) && user.getLastName().equals(parts[1])) {
                    resultList.add(user);
                }
            }
        }
        return resultList;
    }

    public List<User> getUsersByFirstName(String name) {
        List<User> resultList = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().equals(name)) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    public List<User> getUsersByLastName(String name) {
        List<User> resultList = new ArrayList<>();
        for (User user : users) {
            if (user.getLastName().equals(name)) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
