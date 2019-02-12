package com.akudama.books.service;

import com.akudama.books.domain.entity.Author;
import com.akudama.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorDbService {
    @Autowired
    private AuthorRepository repository;

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Optional<Author> getAuthor(final long id) {
        return repository.findById(id);
    }

    public Author saveAuthor(final Author author) {
        return repository.save(author);
    }

    public void deleteAuthor(final long id) {
<<<<<<< 985ccf338a87b0f052e631cbccc62ce4665c128b
        repository.delete(id);
=======
<<<<<<< 985ccf338a87b0f052e631cbccc62ce4665c128b
        repository.delete(id);
=======
        repository.deleteById(id);
>>>>>>> add controller and update deleteById
>>>>>>> add controller and update deleteById
    }

}
