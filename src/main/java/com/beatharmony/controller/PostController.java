package com.beatharmony.controller;

import com.beatharmony.data.PostRepository;
import com.beatharmony.model.Post;
import com.beatharmony.util.StringResponse;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable String id) {
        Optional<Post> op = repository.findById(id);
        return op.get();
    }

    //needs compliance
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return repository.save(post);
    }

    @DeleteMapping("/posts")
    public StringResponse deletePost(@RequestBody StringResponse response) {
        String id = response.getText();
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new StringResponse("Post successfully deleted.");
        } else {
            return new StringResponse("Post not found.");
        }
    }
}
