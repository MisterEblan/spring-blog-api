package com.mreblan.springblog.controllers;

import com.mreblan.springblog.models.Post;
import com.mreblan.springblog.service.impl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/blog")
public class PostController {
    private PostServiceImpl postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }


    @PostMapping("/create_post")
    public String createPost(@RequestBody Post post) {
        postService.savePost(post);

        return "New post was made";
    }

    @PutMapping("/update_post")
    public Post updatePost(@RequestBody Post post) {

        return postService.updatePost(post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);

        return "Post deleted!";
    }
}
