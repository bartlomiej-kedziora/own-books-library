package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.AuthorDbService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return modelConverter.convertToDtoList(service.getAllAuthors(), AuthorDto.class);
    }

    @GetMapping("/details")
    public List<AuthorDetailsDto> getAuthorsWithDetails() {
        return modelConverter.convertToDtoList(service.getAllAuthors(), AuthorDetailsDto.class);
    }

    @GetMapping("/{authorId}")
    public AuthorDto getAuthor(@PathVariable long authorId) {
        return modelConverter.convertToDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new), AuthorDto.class);
    }


    @GetMapping("/{authorId}/details")
    public AuthorDetailsDto getAuthorWithDetails(@PathVariable long authorId) {
        return modelConverter.convertToDto(
                service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new), AuthorDetailsDto.class);
    }

    @GetMapping("/{bookId}/book")
    public Set<AuthorDto> getAuthorsByBook(@PathVariable long bookId) {
        return modelConverter.convertToDtoSet(
                new HashSet<>(service.getAuthorsByBook(bookId).orElseThrow(ItemNotFoundException::new)),
                AuthorDto.class
        );
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable long authorId) {
        service.deleteAuthor(authorId);
    }

    @PutMapping
    public AuthorDto updateAuthor(@RequestBody AuthorDto author) {
        return modelConverter.convertToDto(
                service.updateAuthor(
                        modelConverter.convertToEntity(author, Author.class)
                ),
                AuthorDto.class
        );
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createAuthor(@RequestBody AuthorDto author) {
        service.saveAuthor(modelConverter.convertToEntity(author, Author.class));
    }
}
