package com.akudama.books.service;

import com.akudama.books.domain.entity.Author;
import com.akudama.books.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDbService {

    private AuthorRepository repository;

    @Autowired
    public AuthorDbService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Optional<Author> getAuthor(final long id) {
        return repository.findById(id);
    }

    public Optional<List<Author>> getAuthorsByBook(final long id) {
        return repository.findByBooksId(id);
    }

    public Author saveAuthor(final Author author) {
        return repository.save(author);
    }

    public void deleteAuthor(final long id) {
        repository.deleteById(id);
    }

}
