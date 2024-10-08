package com.mreblan.springblog.repository;

import com.mreblan.springblog.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
