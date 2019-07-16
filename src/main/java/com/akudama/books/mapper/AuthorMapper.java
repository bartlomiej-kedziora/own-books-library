package com.akudama.books.mapper;


import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    public Author mapToAuthor(final AuthorDto authorDto) {
        return new Author(
                authorDto.getId(),
                authorDto.getYearOfBirth(),
                authorDto.getName(),
                authorDto.getSurname(),
                authorDto.getCity(),
                authorDto.getCountry()
        );
    }

    public AuthorDto mapToAuthorDto(final Author author) {
        return AuthorDto.AuthorDtoBuilder.aAuthorDtoBuilder()
                .withId(author.getId())
                .withYearOfBirth(author.getYearOfBirth())
                .withName(author.getName())
                .withSurname(author.getSurname())
                .withCity(author.getCity())
                .withCountry(author.getCountry())
                .build();
    }

    public List<AuthorDto> mapToAuthorDtoList(final List<Author> authorList) {
        return authorList.stream()
                .map(this::mapToAuthorDto)
                .collect(Collectors.toList());
    }
}
