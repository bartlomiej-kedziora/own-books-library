package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.mapper.AuthorDetailsMapper;
import com.akudama.books.mapper.AuthorMapper;
import com.akudama.books.service.AuthorDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorDbService service;
    private final AuthorMapper authorMapper;
    private final AuthorDetailsMapper authorDetailsMapper;

    @Autowired
    public AuthorController(AuthorDbService service, AuthorMapper authorMapper,
            AuthorDetailsMapper authorDetailsMapper) {

        this.service = service;
        this.authorMapper = authorMapper;
        this.authorDetailsMapper = authorDetailsMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<AuthorDto> getAuthors() {
        return authorMapper.mapToAuthorDtoList(service.getAllAuthors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}")
    public AuthorDto getAuthor(@PathVariable long authorId) {
        return authorMapper.mapToAuthorDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}/details")
    public AuthorDetailsDto getAuthorWithDetails(@PathVariable long authorId) {
        return authorDetailsMapper.mapToAuthorDetailsDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/book")
    public List<AuthorDto> getAuthorsByBook(@PathVariable long bookId) {
        return authorMapper.mapToAuthorDtoList(
                service.getAuthorsByBook(bookId).orElseThrow(ItemNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{authorId}")
    public void deleteAuthor(@PathVariable long authorId) {
        service.deleteAuthor(authorId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AuthorDetailsDto updateAuthor(@RequestBody AuthorDetailsDto authorDetailsDto) {
        return authorDetailsMapper.mapToAuthorDetailsDto(
                service.saveAuthor(
                        authorDetailsMapper.mapToAuthor(authorDetailsDto)
                )
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createAuthor(@RequestBody AuthorDetailsDto authorDetailsDto) {
        service.saveAuthor(authorDetailsMapper.mapToAuthor(authorDetailsDto));
    }
}
