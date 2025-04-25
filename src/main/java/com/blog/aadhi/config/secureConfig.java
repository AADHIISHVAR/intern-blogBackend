package com.blog.aadhi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class secureConfig
{
    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    public SecurityFilterChain secur(HttpSecurity http) throws Exception
//    {
//        http.csrf(customizer -> customizer.disable());
//        http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults()); //for the rest api postman access
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register").permitAll() // no auth required here
                        .anyRequest().authenticated() // other URLs need authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // optional: custom login page mapping
                        .defaultSuccessUrl("/posts", true)
                )
                .httpBasic(Customizer.withDefaults());
        System.out.println("no auth for register and login ");

        return http.build();
    }



    @Bean
    public AuthenticationProvider authenticationProvider()
    {//  AuthenticationProvider is and interface and we need to find a class which impliments
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); //DaoAuthenticationProvider extence AuthenticationProvider

//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        System.out.println("trying to hash password");

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();

    }
}
