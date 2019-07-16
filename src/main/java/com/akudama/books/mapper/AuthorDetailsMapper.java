package com.akudama.books.mapper;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorDetailsMapper {

    public Author mapToAuthor(final AuthorDetailsDto authorDetailsDto) {
        return new Author(
                authorDetailsDto.getId(),
                authorDetailsDto.getYearOfBirth(),
                authorDetailsDto.getName(),
                authorDetailsDto.getSurname(),
                authorDetailsDto.getCity(),
                authorDetailsDto.getCountry(),
                mapToBook(authorDetailsDto.getBooks())
        );
    }

    public AuthorDetailsDto mapToAuthorDetailsDto(final Author author) {
        return AuthorDetailsDto.AuthorDetailsDtoBuilder.aAuthorDetailsDtoBuilder()
                .withId(author.getId())
                .withYearOfBirth(author.getYearOfBirth())
                .withName(author.getName())
                .withSurname(author.getSurname())
                .withCity(author.getCity())
                .withCountry(author.getCountry())
                .withBooks(mapToBooksDto(author.getBooks()))
                .build();
    }

    public List<AuthorDetailsDto> mapToAuthorDetailsDtoList(List<Author> authorList) {
        return authorList.stream()
                .map(a -> mapToAuthorDetailsDto(a))
                .collect(Collectors.toList());
    }

    private BookDto mapToBookDto(Book book) {
        return BookDto.BookDtoBuilder.aBookDtoBuilder()
                .withId(book.getId())
                .withYear(book.getYear())
                .withTitlePl(book.getTitlePl())
                .withTitleEn(book.getTitleEn())
                .withSeries(book.getSeries())
                .withGenre(book.getGenre())
                .build();
    }

    private List<BookDto> mapToBooksDto(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }

    private List<Book> mapToBook(List<BookDto> bookDtos) {
        return bookDtos.stream()
                .map(bookDto -> new Book(bookDto.getId(),
                        bookDto.getYear(),
                        bookDto.getTitlePl(),
                        bookDto.getTitleEn(),
                        bookDto.getSeries(),
                        bookDto.getGenre()))
                .collect(Collectors.toList());
    }
}
