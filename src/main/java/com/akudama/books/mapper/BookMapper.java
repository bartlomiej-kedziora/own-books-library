package com.akudama.books.mapper;

import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.dto.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDetailsDto bookDetailsDto) {
        return new Book(
                bookDetailsDto.getId(),
                bookDetailsDto.getYear(),
                bookDetailsDto.getTitlePl(),
                bookDetailsDto.getTitleEn(),
                bookDetailsDto.getSeries(),
                bookDetailsDto.getGenre(),
                bookDetailsDto.getAuthors(),
                bookDetailsDto.getMyScore(),
                bookDetailsDto.getWorldScore(),
                bookDetailsDto.getHomeCollection()
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getYear(),
                book.getTitlePl(),
                book.getTitleEn(),
                book.getSeries(),
                book.getGenre()
        );
    }

    public BookDetailsDto mapToBookDetailsDto(final Book book) {
        return new BookDetailsDto(
                book.getId(),
                book.getYear(),
                book.getTitlePl(),
                book.getTitleEn(),
                book.getSeries(),
                book.getGenre(),
                book.getAuthors(),
                book.getMyScore(),
                book.getWorldScore(),
                book.getHomeCollection()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDto(
                        b.getId(),
                        b.getYear(),
                        b.getTitlePl(),
                        b.getTitleEn(),
                        b.getSeries(),
                        b.getGenre()))
                .collect(Collectors.toList());
    }

    public List<BookDetailsDto> mapToBookDetailsDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDetailsDto(
                        b.getId(),
                        b.getYear(),
                        b.getTitlePl(),
                        b.getTitleEn(),
                        b.getSeries(),
                        b.getGenre(),
                        b.getAuthors(),
                        b.getMyScore(),
                        b.getWorldScore(),
                        b.getHomeCollection()))
                .collect(Collectors.toList());
    }
}
