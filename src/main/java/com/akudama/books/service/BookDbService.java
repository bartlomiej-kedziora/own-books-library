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
