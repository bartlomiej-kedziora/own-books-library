package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.AuthorDetailsDto.AuthorDetailsDtoBuilder.aAuthorDetailsDtoBuilder;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.entity.Author;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDetailsMapper {

    private AuthorMapper authorMapper;
    private BookMapper bookMapper;

    @Autowired
    public AuthorDetailsMapper(AuthorMapper authorMapper,
            BookMapper bookMapper) {
        this.authorMapper = authorMapper;
        this.bookMapper = bookMapper;
    }

    public Author mapToAuthor(final AuthorDetailsDto authorDetailsDto) {
        return new Author(
                authorDetailsDto.getAuthorDto().getId(),
                authorDetailsDto.getAuthorDto().getYearOfBirth(),
                authorDetailsDto.getAuthorDto().getName(),
                authorDetailsDto.getAuthorDto().getSurname(),
                authorDetailsDto.getAuthorDto().getCity(),
                authorDetailsDto.getAuthorDto().getCountry(),
                bookMapper.mapToBookList(authorDetailsDto.getBooks())
        );
    }

    public AuthorDetailsDto mapToAuthorDetailsDto(final Author author) {
        return aAuthorDetailsDtoBuilder()
                .withAuthorDto(authorMapper.mapToAuthorDto(author))
                .withBooks(bookMapper.mapToBookDtoList(author.getBooks()))
                .build();
    }

    public List<AuthorDetailsDto> mapToAuthorDetailsDtoList(List<Author> authorList) {
        return authorList.stream()
                .map(this::mapToAuthorDetailsDto)
                .collect(Collectors.toList());
    }
}
