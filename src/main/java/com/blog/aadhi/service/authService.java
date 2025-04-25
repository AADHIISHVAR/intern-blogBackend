package com.blog.aadhi.service;


import com.blog.aadhi.model.loginModel;
import com.blog.aadhi.model.registerModel;
import com.blog.aadhi.repo.registerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class authService
{
    @Autowired
    private registerRepo repo;

    @Autowired
    AuthenticationManager authManage;

    @Autowired
    JWTService jwtService;

    @Autowired
    loginModel loginModel;

    private BCryptPasswordEncoder encode = new BCryptPasswordEncoder(12);

    public registerModel registerUser(registerModel user)
    {
        String rawPassword = user.getPassword();
        String encodedPassword = encode.encode(rawPassword);
        user.setPassword(encodedPassword);
        return repo.save(user);
    }



    public boolean login(String username, String rawPassword)
    {
        registerModel user = repo.findByUsername(username);

        return user!= null && encode.matches(rawPassword,user.getPassword());
    }

    public boolean verifyUserViaLogin(loginModel user)
    {
        System.out.println("authenticating user");
        Authentication authentication =
                authManage.authenticate(new UsernamePasswordAuthenticationToken(user.getUsernameOrEmail(),user.getPassword()));

        if(authentication.isAuthenticated())
        {
//            return jwtService.generateToken(user.getUsernameOrEmail());
            return true;
        }
        return true;
    }
}

