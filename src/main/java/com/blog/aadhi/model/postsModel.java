package com.blog.aadhi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class postsModel
{
    //id, title, content, author_id, created_at, updated_at
    private Long id;
    private String title;
    private String content;
    // One user -> many posts

    @ManyToOne
    @JoinColumn(name = "loggedid") // This will be the foreign key
    private Long loggedid;
    private String created_at;
    private String updated_at;
}
