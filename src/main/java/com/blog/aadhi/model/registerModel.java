package com.blog.aadhi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class registerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
    @ManyToOne
    @JoinColumn(name = "id")
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private Data DOB;
}
