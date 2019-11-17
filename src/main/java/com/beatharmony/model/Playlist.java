package com.beatharmony.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String id;
    private String title;
    private String description;
    private String user;
    private List<PlaylistItem> items;
    private int numLikes;

    public Playlist() {
    }

    public Playlist(String id, String title, String description, String user, List<PlaylistItem> items) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.items = items;
        this.numLikes = 0;
    }

    public Playlist(String id, String title, String description, String user) {
        this(id, title, description, user, new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<PlaylistItem> getItems() {
        return items;
    }

    public void setItems(List<PlaylistItem> items) {
        this.items = items;
    }

    public void addItem(PlaylistItem item) {
        this.items.add(item);
    }

    public void removeItem(PlaylistItem item) {
        this.items.remove(item);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public void incrementLikes() {
        numLikes++;
    }
}
