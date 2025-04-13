package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class postsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    @Column(nullable = true)
    private String tags;
    private long likecount;

    @Column(nullable = true)
    private String description;

    @Lob
    @Column(nullable = true)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id") // or whatever the foreign key column is
    private registerModel user;


    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private commentsModel comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public registerModel getUser() {
        return user;
    }

    public void setUser(registerModel user) {
        this.user = user;
    }

    public commentsModel getComment() {
        return comment;
    }

    public void setComment(commentsModel comment) {
        this.comment = comment;
    }


}
