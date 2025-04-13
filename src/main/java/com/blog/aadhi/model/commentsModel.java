package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class commentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Long userid;
    private String createdAt;
    private String updatedAt;
    private boolean isEdited;


    // 🔗 Many comments can belong to one post
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private postsModel post;

    // 🔗 Many comments can be made by one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private registerModel user;

    @OneToMany(mappedBy = "comment") // mappedBy must match the field name in postsModel
    private List<postsModel> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public postsModel getPost() {
        return post;
    }

    public void setPost(postsModel post) {
        this.post = post;
    }

    public registerModel getUser() {
        return user;
    }

    public void setUser(registerModel user) {
        this.user = user;
    }

    public List<postsModel> getPosts() {
        return posts;
    }

    public void setPosts(List<postsModel> posts) {
        this.posts = posts;
    }

}
