package com.akudama.books.mapper;

import com.akudama.books.controller.ItemNotFoundException;
import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.service.AuthorDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorDetailsMapper {
    @Autowired
    private AuthorDbService service;

    public Author mapToAuthor(final AuthorDetailsDto authorDetailsDto) {
        return new Author(
                authorDetailsDto.getId(),
                authorDetailsDto.getYearOfBirth(),
                authorDetailsDto.getName(),
                authorDetailsDto.getSurname(),
                authorDetailsDto.getCity(),
                authorDetailsDto.getCountry(),
                getBooksByAuthor(authorDetailsDto.getId())
        );
    }

    public AuthorDetailsDto mapToAuthorDetailsDto(final Author author) {
        return new AuthorDetailsDto(
                author.getId(),
                author.getYearOfBirth(),
                author.getName(),
                author.getSurname(),
                author.getCity(),
                author.getCountry(),
                mapToBooksDto(author.getBooks())
        );
    }

    public List<AuthorDetailsDto> mapToAuthorDetailsDtoList(List<Author> authorList) {
        return authorList.stream()
                .map(a -> new AuthorDetailsDto(
                        a.getId(),
                        a.getYearOfBirth(),
                        a.getName(),
                        a.getSurname(),
                        a.getCity(),
                        a.getCountry(),
                        mapToBooksDto(a.getBooks())))
                .collect(Collectors.toList());
    }

    private AuthorDetailsDto.BookDto mapToBookDto(Book book) {
        return new AuthorDetailsDto.BookDto(book.getId(), book.getTitlePl(), book.getTitleEn());
    }

    private List<AuthorDetailsDto.BookDto> mapToBooksDto(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }


    private List<Book> getBooksByAuthor(long authorId) {
        return service.getAuthor(authorId).orElseThrow(ItemNotFoundException::new).getBooks();
    }
}
