package com.akudama.books.controller;

import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.mapper.BookMapper;
import com.akudama.books.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/books")
public class BookController {
    @Autowired
    private BookDbService service;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) throws ItemNotFoundException {
        return bookMapper.mapToBookDto(service.getBook(bookId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public BookDetailsDto updateBook(@RequestBody BookDetailsDto bookDetailsDto) {
        return bookMapper.mapToBookDetailsDto(service.saveBook(bookMapper.mapToBook(bookDetailsDto)));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDetailsDto bookDetailsDto) {
        service.saveBook(bookMapper.mapToBook(bookDetailsDto));
    }
}
