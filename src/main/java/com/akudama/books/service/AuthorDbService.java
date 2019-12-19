package com.akudama.books.service;

import com.akudama.books.domain.entity.Author;
import com.akudama.books.repository.AuthorRepository;
import com.akudama.books.repository.BookRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorDbService {

    private AuthorRepository repository;
    private BookRepository bookRepository;

    @Autowired
    public AuthorDbService(AuthorRepository repository, BookRepository bookRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
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
        return repository.save(findAuthorIfExists(author));
    }

    public void deleteAuthor(final long id) {
        bookRepository.findByAuthorsId(id)
                .ifPresent(books -> books.forEach(b -> {
                    b.removeAuthorById(id);
                    bookRepository.save(b);
                }));
        repository.deleteById(id);
    }

    private Author findAuthorIfExists(Author author) {
        return repository.findByNameAndSurnameAndYearOfBirthAndCountryAndCity(author.getName(),
                author.getSurname(),
                author.getYearOfBirth(),
                author.getCountry(),
                author.getCity())
                .map(a -> new Author(a.getId(),
                        author.getYearOfBirth(),
                        author.getName(),
                        author.getSurname(),
                        author.getCity(),
                        author.getCountry(),
                        Stream.of(a.getBooks(),
                                author.getBooks())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList())
                ))
                .orElseGet(() -> author);
    }

}
