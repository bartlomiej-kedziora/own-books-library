package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.BookDto.BookDtoBuilder.aBookDtoBuilder;

import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.entity.Book;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
//                bookDto.getId(),
                bookDto.getYear(),
                bookDto.getTitlePl(),
                bookDto.getTitleEn(),
                bookDto.getSeries(),
                bookDto.getGenre()
        );
    }

    public List<Book> mapToBookList(final List<BookDto> bookDtoList) {
        return bookDtoList.stream()
                .map(this::mapToBook)
                .collect(Collectors.toList());
    }

    public BookDto mapToBookDto(final Book book) {
        return aBookDtoBuilder()
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
