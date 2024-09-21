package com.mreblan.springblog.controllers;

import com.mreblan.springblog.models.Author;
import com.mreblan.springblog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {

    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() { return authorService.getAllAuthors(); }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) { return authorService.getAuthorById(id); }

    @PostMapping("/create_author")
    public String createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);

        return "Author saved!";
    }

    @PutMapping("/{id}/update_author")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) { return authorService.updateAuthor(id, author); }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);

        return "Author deleted!";
    }
}
