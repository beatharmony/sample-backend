package com.beatharmony.service;

import com.beatharmony.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    private User rishma = new User("2", "Rishma Mendhekar", "rmendhekar", "rishma@gmail.com", (List<User>) null);
    private User ankit = new User("3", "Ankit Verma", "averma", "ankit@gmail.com", (List<User>) null);
    private User pradyumna = new User("4", "Pradyumna Mukunda", "pmukunda", "pradyumna@gmail.com", (List<User>) null);
    private User christian = new User("5", "Christian Graham", "cgraham", "christian@gmail.com", (List<User>) null);

    List<User> trusted = new ArrayList<>(Arrays.asList(rishma, ankit, pradyumna, christian));
    private User justin = new User("1", "Justin Higgins", "jhiggins", "just1higg@gmail.com", trusted);

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

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
