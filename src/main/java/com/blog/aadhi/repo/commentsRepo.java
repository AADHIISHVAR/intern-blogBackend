package com.blog.aadhi.repo;

import com.blog.aadhi.model.commentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentsRepo extends JpaRepository<commentsModel,Long> {
}
