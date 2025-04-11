package com.blog.aadhi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class commentsModel {
    private Long id;
    private String comment;
//    private Long postId;
    private Long userId;
    private String username;
    private String createdAt;
    private String updatedAt;
    private boolean isEdited;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<postsModel> posts;
}
