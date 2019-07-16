package com.akudama.books.controller;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.mapper.AuthorDetailsMapper;
import com.akudama.books.mapper.AuthorMapper;
import com.akudama.books.service.AuthorDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final AuthorDbService service;
    private final AuthorMapper authorMapper;
    private final AuthorDetailsMapper authorDetailsMapper;
    @Autowired
    public AuthorController(AuthorDbService service, AuthorMapper authorMapper, AuthorDetailsMapper authorDetailsMapper) {

        this.service = service;
        this.authorMapper = authorMapper;
        this.authorDetailsMapper = authorDetailsMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AuthorDto> getAuthors() {
        return authorMapper.mapToAuthorDtoList(service.getAllAuthors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}")
    public AuthorDto getAuthor(@PathVariable long authorId) {
        return authorMapper.mapToAuthorDto(service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}/details")
    public AuthorDetailsDto getAuthorWithDetails(@PathVariable long authorId) {
        return authorDetailsMapper.mapToAuthorDetailsDto(service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new));
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
