package com.akudama.books.mapper;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    public Author mapToAuthor(final AuthorDetailsDto authorDetailsDto) {
        return new Author(
                authorDetailsDto.getId(),
                authorDetailsDto.getYearOfBirth(),
                authorDetailsDto.getName(),
                authorDetailsDto.getSurname(),
                authorDetailsDto.getCity(),
                authorDetailsDto.getCountry(),
                authorDetailsDto.getBooks()
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

    public AuthorDetailsDto mapToAuthorDetailsDto(final Author author) {
        return new AuthorDetailsDto(
                author.getId(),
                author.getYearOfBirth(),
                author.getName(),
                author.getSurname(),
                author.getCity(),
                author.getCountry(),
                author.getBooks()
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

    public List<AuthorDetailsDto> mapToAuthorDetailsDtoList(List<Author> authorList) {
        return authorList.stream()
                .map(a -> new AuthorDetailsDto(
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
