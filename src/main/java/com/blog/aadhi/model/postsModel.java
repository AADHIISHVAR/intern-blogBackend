package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(nullable = false) // FK to registerModel
    private registerModel user_id;
}

