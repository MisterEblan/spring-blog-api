package com.mreblan.springblog.service.impl;

import com.mreblan.springblog.exceptions.ResourceNotFoundException;
import com.mreblan.springblog.models.Author;
import com.mreblan.springblog.repository.AuthorRepository;
import com.mreblan.springblog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;

    @Override
    public List<Author> getAllAuthors() {
        String logMessage = "All authors returned";
        log(logMessage);

        return repository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        String logMessage = String.format("Author with id -- %d -- returned", id);
        log(logMessage);

        return repository.findById(id);
    }

    @Override
    public Author saveAuthor(Author author) {
        String logMessage = String.format("Author saved:\n%s", author.toString());
        log(logMessage);

        return repository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id -- " + id + " -- not found"));

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setUsername(author.getUsername());
        existingAuthor.setEmail(author.getEmail());
        existingAuthor.setPassword(author.getPassword());

        String logMessage = String.format("Author update:\n%s", author.toString());
        log(logMessage);

        return repository.save(existingAuthor);
    }

    @Override
    public void deleteAuthorById(Long id) {
        String logMessage = String.format("Author with id -- %d -- deleted", id);
        log(logMessage);

        repository.deleteById(id);
    }

    private void log(String msg) {
        String logStart = "\n========LOG========\n";
        String logEnd   = "\n======LOG END======\n";

        System.out.println(logStart + msg + logEnd);
    }
}
