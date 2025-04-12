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
    private String tags;

    @Column(nullable = false)
    private String description;

    @Lob
    @Column(columnDefinition = "LONGBLOB", nullable = true)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id") // or whatever the foreign key column is
    private registerModel user;


    @ManyToOne
    @JoinColumn(nullable = false)
    private commentsModel comment; // This should match the mappedBy in commentsModel

}
