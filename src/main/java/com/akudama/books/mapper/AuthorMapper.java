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
        return new AuthorDto(
                author.getId(),
                author.getYearOfBirth(),
                author.getName(),
                author.getSurname(),
                author.getCity(),
                author.getCountry()
        );
    }

    public List<AuthorDto> mapToAuthorDtoList(final List<Author> authorList) {
        return authorList.stream()
                .map(a -> new AuthorDto(
                        a.getId(),
                        a.getYearOfBirth(),
                        a.getName(),
                        a.getSurname(),
                        a.getCity(),
                        a.getCountry()))
                .collect(Collectors.toList());
    }
}
