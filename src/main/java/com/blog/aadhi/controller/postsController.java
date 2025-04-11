package com.blog.aadhi.controller;

import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.postsModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.service.postsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/blog")
public class postsController
{
    private final postsService service;

    public postsController(postsService service) {
        this.service = service;
    }



    @PostMapping("/register")
    public ResponseEntity<String> entryUser(@RequestBody registerModel user) {
        if (user == null) {
            return ResponseEntity.badRequest().body("User data is missing");
        }

        service.entryNewUser(user);  // save user, no return needed
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    long userId=0;

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestBody loginModel login) {
        if (login == null) {
            return ResponseEntity.badRequest().body("Login data is missing");
        }

        registerModel user = service.checkLogin(login);

        if (user != null)
        {
            userId = user.getId();
            return ResponseEntity.ok("Login successful. Your ID is: " + user.getId());

        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<List<postsModel>> getAllPosts()
    {
        return new ResponseEntity<>(service.getAllPosts(),HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<List<registerModel>> showProfile(int id)
    {
        return ResponseEntity.ok(service.showProfile(id)); //return new ResponseEntity<>(service.showProfile(id), HttpStatus.OK);
    }



}
