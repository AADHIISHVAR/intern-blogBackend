package com.blog.aadhi.repo;

import com.blog.aadhi.model.postsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postsRepo extends JpaRepository<postsModel,Long>
{

}
