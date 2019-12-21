package com.akudama.books.service;

import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.repository.AuthorRepository;
import com.akudama.books.repository.BookRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDbService {

    private BookRepository repository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookDbService(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBook(final long id) {
        return repository.findById(id);
    }

    public Optional<List<Book>> getBooksByAuthor(final long id) {
        return repository.findByAuthorsId(id);
    }

    public Book saveBook(final Book book) {
        return repository.save(findBookIfExistsOrGetCurrent(book));
    }

    public void deleteBook(final long id) {
        authorRepository.findByBooksId(id)
                .ifPresent(authors -> authors.forEach(a -> {
                    a.removeBookById(id);
                    authorRepository.save(a);
                }));
        repository.deleteById(id);
    }

    private Book findBookIfExistsOrGetCurrent(final Book book) {
        book.setAuthors(findAuthorIfExistsOrGetCurrent(book.getAuthors()));
        return repository.findByTitleAndTitleEngAndSeriesAndGenreAndYear(
                book.getTitle(), book.getTitleEng(), book.getSeries(), book.getGenre(), book.getYear())
                .map(b -> new Book(b.getId(),
                        book.getYear(),
                        book.getTitle(),
                        book.getTitleEng(),
                        book.getSeries(),
                        book.getGenre(),
                        Stream.of(b.getAuthors(), book.getAuthors())
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList()
                                ),
                        book.getHomeCollectionItems()))
                .orElseGet(() -> book);
    }

    private List<Author> findAuthorIfExistsOrGetCurrent(List<Author> authors) {
        return authors.stream()
                .map(this::getAuthorWithIdIfExists)
                .collect(Collectors.toList());
    }

    private Author getAuthorWithIdIfExists(Author author) {
        return authorRepository.findByNameAndSurnameAndYearOfBirthAndCountryAndCity(
                author.getName(), author.getSurname(), author.getYearOfBirth(), author.getCountry(), author.getCity()
        ).orElse(author);
    }
}
