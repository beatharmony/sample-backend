package com.beatharmony.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String user;
    private String text;
    private List<String> likedBy;

    public Post() {}

    public Post(String id, String user, String text, List<String> likedBy) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.likedBy = likedBy;
    }

    public Post(String id, String user, String text) {
        this(id, user, text, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addLikedBy(String id) {
        if (likedBy == null) {
            likedBy = new ArrayList<>();
        }
        if (!likedBy.contains(id)) {
            likedBy.add(id);
        }
    }

    public void removeLikedBy(String id) {
        if (likedBy == null) {
            likedBy = new ArrayList<>();
        }
        if (likedBy.contains(id)) {
            likedBy.remove(id);
        }
    }

    @Override
    public boolean equals(Object o) {
        Post other = (Post) o;
        if (this.id.equals(other.getId())) {
            return true;
        }
        return false;
    }
}
