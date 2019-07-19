package com.akudama.books.mapper;


import static com.akudama.books.domain.dto.AuthorDto.AuthorDtoBuilder.aAuthorDtoBuilder;

import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.entity.Author;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

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

    public List<Author> mapToAuthorList(final List<AuthorDto> authorDtoList) {
        return authorDtoList.stream()
                .map(this::mapToAuthor)
                .collect(Collectors.toList());
    }

    public AuthorDto mapToAuthorDto(final Author author) {
        return aAuthorDtoBuilder()
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
