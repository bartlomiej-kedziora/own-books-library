package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.BookDbService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final BookDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public BookController(BookDbService service, ModelConverter modelConverter) {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<BookDto> getBooks() {
        return modelConverter.convertToDtoList(service.getAllBooks(), BookDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBook(@PathVariable long bookId) {
        return modelConverter.convertToDto(
                service.getBook(bookId).orElseThrow(ItemNotFoundException::new),
                BookDto.class
        );
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/details")
    public BookDetailsDto getBookWithDetails(@PathVariable long bookId) {
        return modelConverter.convertToDto(
                service.getBook(bookId).orElseThrow(ItemNotFoundException::new), BookDetailsDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}/author")
    public Set<BookDto> getBooksByAuthor(@PathVariable long authorId) {
        return modelConverter.convertToDtoList(
                service.getBooksByAuthor(authorId).orElseThrow(ItemNotFoundException::new),
                BookDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public void deleteBook(@PathVariable long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookDetailsDto updateBook(@RequestBody BookDetailsDto book) {
        return modelConverter.convertToDto(
                service.saveBook(
                        modelConverter.convertToEntity(book, Book.class)
                ),
                BookDetailsDto.class
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto book) {
        service.saveBook(
                modelConverter.convertToEntity(book, Book.class));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, value = "/details")
    public void createBook(@RequestBody BookDetailsDto book) {
        service.saveBook(
                modelConverter.convertToEntity(book, Book.class));
    }
}
