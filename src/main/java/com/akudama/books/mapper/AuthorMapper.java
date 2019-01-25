package com.akudama.books.mapper;

import com.akudama.books.domain.Author;
import com.akudama.books.domain.AuthorDto;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {
    public Author mapToAuthor(AuthorDto authorDto) {
        return new Author(
                authorDto.getId(),
                authorDto.getYearOfBirth(),
                authorDto.getName(),
                authorDto.getSurname(),
                authorDto.getCity(),
                authorDto.getCountry(),
                authorDto.getBooks()
                );
    }

    public AuthorDto mapToAuthorDto(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getYearOfBirth(),
                author.getName(),
                author.getSurname(),
                author.getCity(),
                author.getCountry(),
                author.getBooks()
        );
    }

    public List<AuthorDto> mapToAuthorDtoList(List<Author> authorList) {
        return authorList.stream()
                .map(a -> new AuthorDto(
                        a.getId(),
                        a.getYearOfBirth(),
                        a.getName(),
                        a.getSurname(),
                        a.getCity(),
                        a.getCountry(),
                        a.getBooks()))
                .collect(Collectors.toList());
    }
}
