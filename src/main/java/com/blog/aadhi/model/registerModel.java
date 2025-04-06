package com.blog.aadhi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private Data DOB;
}
