package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.mapper.BookDetailsMapper;
import com.akudama.books.mapper.BookMapper;
import com.akudama.books.service.BookDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final BookDbService service;
    private final BookMapper bookMapper;
    private final BookDetailsMapper bookDetailsMapper;

    @Autowired
    public BookController(BookDbService service, BookMapper bookMapper,
            BookDetailsMapper bookDetailsMapper) {
        this.service = service;
        this.bookMapper = bookMapper;
        this.bookDetailsMapper = bookDetailsMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBook(@PathVariable long bookId) {
        return bookMapper
                .mapToBookDto(service.getBook(bookId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/details")
    public BookDetailsDto getBookWithDetails(@PathVariable long bookId) {
        return bookDetailsMapper.mapToBookDetailsDto(
                service.getBook(bookId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}/author")
    public List<BookDto> getBooksByAuthor(@PathVariable long authorId) {
        return bookMapper.mapToBookDtoList(
                service.getBooksByAuthor(authorId).orElseThrow(ItemNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public void deleteBook(@PathVariable long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookDetailsDto updateBook(@RequestBody BookDetailsDto bookDetailsDto) {
        return bookDetailsMapper.mapToBookDetailsDto(
                service.saveBook(
                        bookDetailsMapper.mapToBook(bookDetailsDto)
                )
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDetailsDto bookDetailsDto) {
        service.saveBook(bookDetailsMapper.mapToBook(bookDetailsDto));
    }
}
