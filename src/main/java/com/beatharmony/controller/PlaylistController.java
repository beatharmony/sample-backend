package com.beatharmony.controller;

import com.beatharmony.data.PlaylistRepository;
import com.beatharmony.model.Playlist;
import com.beatharmony.util.StringResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaylistController {
    private final PlaylistRepository repository;

    public PlaylistController(PlaylistRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/playlists")
    public void addPost(@RequestBody Playlist playlist) {
        repository.save(playlist);
    }

    @GetMapping("/playlists")
    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }

    @PutMapping("/playlists/{id}/like")
    public StringResponse likePlaylist(@PathVariable String id) {
        if (repository.existsById(id)) {
            Playlist source = repository.findById(id).get();
            source.incrementLikes();
            repository.save(source);
            return new StringResponse("Playlist liked, number of likes is now " + source.getNumLikes());
        } else {
            return new StringResponse("Post not found.");
        }
    }

    @GetMapping("/playlists/{id}")
    public Playlist getPlaylistById(@PathVariable String id) {
        Optional<Playlist> playlist = repository.findById(id);

        if (playlist.get() != null) {
            return playlist.get();
        }
        return null;
    }

    @GetMapping("/playlists/user/{id}")
    public List<Playlist> getPlaylistsByUser(@PathVariable String userId) {
        List<Playlist> list = repository.findAll();
        List<Playlist> toReturn = new ArrayList<>();
        for (Playlist p : list) {
            if (p.getUser().equals(userId)) {
                toReturn.add(p);
            }
        }
        return toReturn;
    }
}
