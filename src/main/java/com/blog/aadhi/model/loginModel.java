package com.blog.aadhi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class loginModel {
    private String usernameOrEmail;  // ✅ camelCase
    private String password;

    // Getter for usernameOrEmail
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    // Setter for usernameOrEmail
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
