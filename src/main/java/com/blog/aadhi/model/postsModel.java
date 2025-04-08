package com.blog.aadhi.model;

import jakarta.persistence.*;

public class postsModel
{
    //id, title, content, author_id, created_at, updated_at
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
    private Long id;
    private String title;
    private String content;
    // One user -> many posts

    // Many posts belong to one login
    @ManyToOne
    @JoinColumn(name = "login_id")  // foreign key in post table
    private loginModel login;

    private String created_at;
    private String updated_at;
}
