package com.blog.aadhi.service;

import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.postsModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.repo.postsRepo;
import com.blog.aadhi.repo.registerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Transactional
    public registerModel entryNewUser(registerModel user) {
        System.out.println("Entered the show all service layer");
        return regRepo.save(user);
    }


    public registerModel checkLogin(String UsernameOrEmail,String pass)
    {
        return regRepo.findByUsernameOrEmailAndPassword(UsernameOrEmail,pass);
    }


    public List<postsModel> getAllPosts()
    {
        return postRepo.findAll();
    }

//    public List<registerModel> showProfile(int id)
//    {
//        return regRepo.findAll();
//    }

    public postsModel addpost(postsModel post) {
        System.out.println("entered service layer to save the post");
        return postRepo.save(post); // NOT saveAll
    }

//    public List<postsModel> getPostById(Long postId)
//    {
//        return postRepo.findAllById(postId);
//        return null;
//    }
}
