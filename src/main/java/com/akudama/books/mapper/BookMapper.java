package com.akudama.books.mapper;

import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getYear(),
                bookDto.getTitlePl(),
                bookDto.getTitleEn(),
                bookDto.getSeries(),
                bookDto.getGenre()
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return BookDto.BookDtoBuilder.aBookDtoBuilder()
                .withId(book.getId())
                .withYear(book.getYear())
                .withTitlePl(book.getTitlePl())
                .withTitleEn(book.getTitleEn())
                .withSeries(book.getSeries())
                .withGenre(book.getGenre())
                .build();
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
