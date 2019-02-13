package com.akudama.books.service;

import com.akudama.books.domain.entity.Book;
import com.akudama.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDbService {
    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBook(final long id) {
        return repository.findById(id);
    }

    public Book saveBook(final Book book) {
        return repository.save(book);
    }

    public void deleteBook(final long id) {
        repository.deleteById(id);
    }
}
