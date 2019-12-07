package com.akudama.books.service;

import com.akudama.books.domain.entity.Book;
import com.akudama.books.repository.BookRepository;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDbService {

    private BookRepository repository;

    @Autowired
    public BookDbService(BookRepository repository) {
        this.repository = repository;
    }

    public Set<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBook(final long id) {
        return repository.findById(id);
    }

    public Optional<Set<Book>> getBooksByAuthor(final long id) {
        return repository.findByAuthorsId(id);
    }

    public Book saveBook(final Book book) {
        return repository.save(findBookIfExistsOrGetCurrent(book));
    }

    public void deleteBook(final long id) {
        repository.deleteById(id);
    }

    private Book findBookIfExistsOrGetCurrent(final Book book) {
        return repository.findByTitleAndTitleEngAndSeriesAndGenreAndYear(
                book.getTitle(), book.getTitleEng(), book.getSeries(), book.getGenre(), book.getYear())
                .map(b -> new Book(b.getId(),
                        book.getYear(),
                        book.getTitle(),
                        book.getTitleEng(),
                        book.getSeries(),
                        book.getGenre(),
                        Stream.of(b.getAuthors(),
                                book.getAuthors())
                                .flatMap(l -> l.stream())
                                .collect(Collectors.toSet()
                                ),
                        book.getHomeCollectionItems()))
                .orElseGet(() -> book);
    }
}
