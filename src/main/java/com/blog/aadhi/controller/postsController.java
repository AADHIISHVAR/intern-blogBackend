package com.blog.aadhi.controller;

import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.postsModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.service.authService;
import com.blog.aadhi.service.postsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private authService authService;


    @PostMapping("/register")
    public ResponseEntity<String> entryUser(@RequestBody registerModel user) {
        if (user == null) {
            return ResponseEntity.badRequest().body("User data is missing");
        }

        authService.registerUser(user);  // save user, no return needed
        return ResponseEntity.ok("Registered sucessfully");
    }


    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestBody loginModel login)
    {
        if (login == null)
        {
            return ResponseEntity.badRequest().body("Login data is missing");
        }
        System.out.println("trying to login");
        if (authService.verifyUserViaLogin(login))
        {
            return ResponseEntity.ok("the user is authenticated");
        }
        return ResponseEntity.badRequest().body("Login data is missing");
    }



//        String UsernameOrEmail = login.getUsernameOrEmail();
//        String pass = login.getPassword();
//
//        registerModel user = service.checkLogin(UsernameOrEmail,pass);
//        if (user != null)
//        {
//            return ResponseEntity.ok("Login successful");// Your ID is: " + user.getId()
//        }
//        else
//        {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }


    @GetMapping("/posts")
    public ResponseEntity<List<postsModel>> getAllPosts()
    {
        return new ResponseEntity<>(service.getAllPosts(),HttpStatus.OK);
    }

    @PostMapping("/createPost")
    public ResponseEntity<String> addPost(@RequestBody postsModel post) {
        service.addpost(post);
        return ResponseEntity.ok("Post created successfully");
    }


//Redunent
//    @GetMapping("/profile/{id}")
//    public ResponseEntity<List<registerModel>> showProfile(int id)
//    {
//        return ResponseEntity.ok(service.showProfile(id)); //return new ResponseEntity<>(service.showProfile(id), HttpStatus.OK);
//    }
//    @GetMapping("/profile/{id}")
//    public ResponseEntity<List<postsModel>> getPostById(@PathVariable Long postId)
//    {
//        return ResponseEntity.ok(service.getPostById(postId));
//
//    }

}
