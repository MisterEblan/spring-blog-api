package com.mreblan.springblog.repository;

import com.mreblan.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
