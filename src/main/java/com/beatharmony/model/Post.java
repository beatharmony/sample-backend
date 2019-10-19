package com.beatharmony.model;

import org.apache.tomcat.jni.Local;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class Post {
    private String id;
    private String postedBy;
    private String text;
    private String link;
    private List<String> likedBy;
    private LocalDateTime dateTime;
    private String username;
    private String profilePic;

    public Post() {}

    public Post(String id, String postedBy, String text, String link, List<String> likedBy, String username, String profilePic) {
        this.id = id;
        this.postedBy = postedBy;
        this.text = text;
        this.link = link;
        this.likedBy = likedBy;
        this.username = username;
        this.profilePic = profilePic;
    }

    public Post(String id, String postedBy, String text, String link, String username, String profilePic) {
        this(id, postedBy, text, link, new ArrayList<>(), username, profilePic);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
