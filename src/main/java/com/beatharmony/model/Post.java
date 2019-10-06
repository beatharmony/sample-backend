package com.beatharmony.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String postedBy;
    private String text;
    private String link;
    private List<String> likedBy;

    public Post() {}

    public Post(String id, String postedBy, String text, String link, List<String> likedBy) {
        this.id = id;
        this.postedBy = postedBy;
        this.text = text;
        this.link = link;
        this.likedBy = likedBy;
    }

    public Post(String id, String postedBy, String text, String link) {
        this(id, postedBy, text, link, new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
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
