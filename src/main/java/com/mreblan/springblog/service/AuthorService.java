package com.mreblan.springblog.service;

import com.mreblan.springblog.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author       saveAuthor(Author author);

    Author       updateAuthor(Long id, Author author);

    void         deleteAuthorById(Long id);

}
