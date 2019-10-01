package com.beatharmony.model;

import java.util.List;

public class Playlist {
    private String title;
    private String description;
    private String user;
    private List<PlaylistItem> items;

    public Playlist() {
    }

    public Playlist(String title, String description, String user, List<PlaylistItem> items) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.items = items;
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
}
