package com.beatharmony.controller;

import com.beatharmony.model.User;
import com.beatharmony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/id/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/users/name/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
