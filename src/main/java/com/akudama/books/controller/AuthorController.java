package com.akudama.books.controller;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.AuthorDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final AuthorDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public AuthorController(AuthorDbService service, ModelConverter modelConverter) {

        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AuthorDto> getAuthors() {
        return modelConverter.convertToDtoList(service.getAllAuthors(), AuthorDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}")
    public AuthorDto getAuthor(@PathVariable long authorId) {
        return modelConverter.convertToDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new), AuthorDto.class);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}/details")
    public AuthorDetailsDto getAuthorWithDetails(@PathVariable long authorId) {
        return modelConverter.convertToDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new), AuthorDetailsDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/book")
    public List<AuthorDto> getAuthorsByBook(@PathVariable long bookId) {
        return modelConverter.convertToDtoList(
                service.getAuthorsByBook(bookId).orElseThrow(ItemNotFoundException::new),
                AuthorDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{authorId}")
    public void deleteAuthor(@PathVariable long authorId) {
        service.deleteAuthor(authorId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AuthorDetailsDto updateAuthor(@RequestBody AuthorDetailsDto authorDto) {
        return modelConverter.convertToDto(
                service.saveAuthor(
                        modelConverter.convertToEntity(authorDto, Author.class)
                ),
                AuthorDetailsDto.class
        );
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createAuthor(@RequestBody AuthorDetailsDto author) {
        service.saveAuthor(modelConverter.convertToEntity(author, Author.class));
    }
}
