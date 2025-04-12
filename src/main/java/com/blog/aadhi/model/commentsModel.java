package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class commentsModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
//    private Long postId;
    private Long userId;
    private String username;
    private String createdAt;
    private String updatedAt;
    private boolean isEdited;

    @OneToMany(mappedBy = "comment") // Correctly referencing the field name in postsModel
    private List<postsModel> posts;

}
