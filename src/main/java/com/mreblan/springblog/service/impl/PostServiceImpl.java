package com.mreblan.springblog.service.impl;

import com.mreblan.springblog.models.Author;
import com.mreblan.springblog.models.Post;
import com.mreblan.springblog.repository.AuthorRepository;
import com.mreblan.springblog.repository.PostRepository;
import com.mreblan.springblog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private PostRepository repository;

    AuthorRepository authorRepository;

    @Override
    public List<Post> getAllPosts() {
        String logMessage = "All posts returned";
        log(logMessage);

        return repository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        String logMessage = String.format("Post with id -- %d -- returned", id);
        log(logMessage);

        return repository.findById(id);
    }

    @Override
    public Post savePost(Post newPost) {
        String logMessage = String.format("Post saved:\n%s", newPost.toString());
        log(logMessage);

        Post post = new Post();

        post.setText(newPost.getText());
        post.setTitle(newPost.getTitle());

        Author author = authorRepository.findAllById(Collections.singleton(newPost.getAuthor().getId()))
                .stream()
                .findFirst()
                .orElse(newPost.getAuthor());

        post.setAuthor(author);

        return repository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        String logMessage = String.format("Post update: \n%s", post.toString());
        log(logMessage);

        return repository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        String logMessage = String.format("Post with id -- %d -- deleted", id);
        log(logMessage);

        repository.deleteById(id);
    }

    private void log(String msg) {
        String logStart = "\n========LOG========\n";
        String logEnd   = "\n======LOG END======\n";

        System.out.println(logStart + msg + logEnd);
    }
}
