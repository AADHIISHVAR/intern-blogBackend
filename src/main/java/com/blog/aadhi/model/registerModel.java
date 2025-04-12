package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class registerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;

    @Temporal(TemporalType.DATE)
    private Date DOB;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<postsModel> posts;  //= new ArrayList<>();
}

