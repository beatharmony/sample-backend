package com.beatharmony.controller;

import com.beatharmony.model.User;
import com.beatharmony.data.UserRepository;
import com.beatharmony.util.StringResponse;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
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
    public StringResponse addTrustedUser(@PathVariable String id, @RequestBody StringResponse response) {
        User source = repository.findById(id).get();
        if (source != null) {
            if (source.addTrustedUser(response.getText())) {
                repository.save(source);
                return new StringResponse("Successfully added user " + response.getText() + " to user " + id);
            } else {
                return new StringResponse("User " + response.getText() + " already exists in list of user " + id);
            }
        }
        return new StringResponse("Action failed");
    }

    @PutMapping(value="/users/removetrusted/{id}")
    public StringResponse removeTrustedUser(@PathVariable String id, @RequestBody StringResponse response) {
        User source = repository.findById(id).get();
        if (source != null) {
            if (source.removeTrustedUser(response.getText())) {
                repository.save(source);
                return new StringResponse("Successfully removed user " + response.getText() + " from user " + id);
            } else {
                return new StringResponse("Could not find user " + response.getText() + " in list of user " + id);
            }
        }
        return new StringResponse("Action failed");
    }

    @GetMapping(value="/users/{id}/trusted")
    public List<User> getTrustedList(@PathVariable String id) {
        User source = repository.findById(id).get();
        List<String> trustedIDs= source.getTrustedUsers();
        List<User> trustedUsers = new ArrayList<>();
        for (String s : trustedIDs) {
            trustedUsers.add(repository.findById(s).get());
        }
        return trustedUsers;
    }

    @DeleteMapping(value="/users/id")
    public StringResponse deleteUser(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new StringResponse("User " + id + "removed successfully.");
        } else {
            return new StringResponse("User " + id+ "was not found, could not remove.");
        }
    }
}
