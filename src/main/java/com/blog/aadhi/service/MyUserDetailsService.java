package com.blog.aadhi.service;

import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.model.userDetails;
import com.blog.aadhi.repo.registerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private registerRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        System.out.println("Trying to authenticate user: " + username);
        registerModel user = userRepo.findByUsername(username);


        //todo if users is not null return users

        if(user == null)
        {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }

        return new userDetails(user);
    }
}

