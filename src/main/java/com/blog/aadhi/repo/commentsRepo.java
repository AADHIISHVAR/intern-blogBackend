package com.blog.aadhi.repo;

import com.blog.aadhi.model.commentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface commentsRepo extends JpaRepository<commentsModel,Long> {
}
