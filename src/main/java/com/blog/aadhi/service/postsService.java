package com.blog.aadhi.service;

import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.postsModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.repo.postsRepo;
import com.blog.aadhi.repo.registerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postsService
{
    private final registerRepo regRepo;
    private final postsRepo postRepo;


    public postsService(registerRepo repo, postsRepo postRepo) {
        this.regRepo = repo;
        this.postRepo = postRepo;
    }

    public registerModel entryNewUser(registerModel user)
    {
        System.out.println("entered teh show all service  layer");

        return regRepo.save(user);
    }

    public registerModel checkLogin(loginModel login) {
        return regRepo.findByUsernameOrEmailAndPassword(
                login.getUsername_or_email(),
                login.getPassword()
        );
    }

    public List<postsModel> getAllPosts()
    {
        return postRepo.findAll();
    }

}
