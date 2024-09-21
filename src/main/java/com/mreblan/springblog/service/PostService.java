package com.mreblan.springblog.service;

import com.mreblan.springblog.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);

    Post savePost(Post post);

    Post updatePost(Post post);

    void deletePost(Long id);
}
