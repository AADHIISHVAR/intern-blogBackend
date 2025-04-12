package com.blog.aadhi.repo;

import com.blog.aadhi.model.registerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface registerRepo extends JpaRepository<registerModel, Long>
{
    @Query("SELECT r FROM registerModel r WHERE (r.email = ?1 OR r.username = ?1) AND r.password = ?2")
    registerModel findByUsernameOrEmailAndPassword(String usernameOrEmail, String password);

//    @Query("SELECT r FORM registerModel  WHERE r.email = ?1 OR r.username = ?1 AND r.password = ?2")
//    registerModel findId(String email, String password);

}
