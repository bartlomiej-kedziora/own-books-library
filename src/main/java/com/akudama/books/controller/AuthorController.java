package com.akudama.books.controller;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
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
    @Autowired
    private AuthorDbService service;
    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorController() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AuthorDto> getAuthors() {
        return authorMapper.mapToAuthorDtoList(service.getAllAuthors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}")
    public AuthorDto getAuthor(@PathVariable long authorId) {
        return authorMapper.mapToAuthorDto(service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{authorId}")
    public void deleteAuthor(@PathVariable long authorId) {
        service.deleteAuthor(authorId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AuthorDetailsDto updateAuthor(@RequestBody AuthorDetailsDto authorDetailsDto) {
        return authorMapper.mapToAuthorDetailsDto(service.saveAuthor(authorMapper.mapToAuthor(authorDetailsDto)));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createAuthor(@RequestBody AuthorDetailsDto authorDetailsDto) {
        service.saveAuthor(authorMapper.mapToAuthor(authorDetailsDto));
    }
}
