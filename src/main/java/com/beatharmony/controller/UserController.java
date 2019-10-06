package com.beatharmony.controller;

import com.beatharmony.model.User;
import com.beatharmony.data.UserRepository;
import com.beatharmony.util.StringResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable String id) {
        Optional<User> op =  repository.findById(id);
        return op.get();
    }

    @GetMapping("/users/name/first/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return repository.findByFirstName(name);
    }

    @GetMapping("/users/username/{username}")
    public List<User> getUserByUsername(@PathVariable String username) {
        return repository.findByUsername(username);
    }

    @PostMapping(value="/users")
    public void addUser(@RequestBody User user) {
        repository.save(user);
    }

    @PutMapping(value="/users/addtrusted/{id}")
    public User addTrustedUser(@PathVariable String id, @RequestBody StringResponse response) {
        User source = repository.findById(id).get();
        if (source != null) {
            source.addTrustedUser(response.getText());
        }
        repository.save(source);
        return source;
    }

    @PutMapping(value="/users/removetrusted/{id}")
    public User removeTrustedUser(@PathVariable String id, @RequestBody StringResponse response) {
        User source = repository.findById(id).get();
        if (source != null) {
            source.removeTrustedUser(response.getText());
        }
        repository.save(source);
        return source;
    }
}
