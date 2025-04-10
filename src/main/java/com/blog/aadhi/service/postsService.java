package com.blog.aadhi.service;

import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.repo.registerRepo;
import org.springframework.stereotype.Service;

@Service
public class postsService
{
    private final registerRepo repo;
    private final

    public postsService(registerRepo repo) {
        this.repo = repo;
    }

    public registerModel entryNewUser(registerModel user)
    {
        System.out.println("entered teh show all service  layer");

        return repo.save(user);
    }


    public boolean checkLogin(loginModel login) {
        registerModel username = repo.findByUsernameAndPassword(login.getUsername_or_email(), login.getPassword());
        registerModel userEmail = repo.findByEmailAndPassword(login.getUsername_or_email(), login.getPassword());

       if(userEmail!=null||username!=null)
       {
           return true;
       }
       else{
           return false;
       }

    }

}
