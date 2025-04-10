package com.blog.aadhi.repo;

import com.blog.aadhi.model.registerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface registerRepo extends JpaRepository<registerModel, Long>
{
    @Query("SELECT r FROM registerModel r WHERE r.username = ?1 AND r.password = ?2")
    registerModel findByUsernameAndPassword(String username, String password);

    @Query("SELECT r FROM registerModel WHERE r.email = ?1 AND r.password = ?2")
    registerModel findByEmailAndPassword(String email, String password);
}
