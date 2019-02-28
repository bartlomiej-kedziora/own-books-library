package com.akudama.books.mapper;

import com.akudama.books.controller.ItemNotFoundException;
import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDetailsMapper {
    @Autowired
    private BookDbService service;
    @Autowired
    private MyScoreMapper myScoreMapper;
    @Autowired
    private WorldScoreMapper worldScoreMapper;
    @Autowired
    private HomeCollectionMapper homeCollectionMapper;

    public Book mapToBook(final BookDetailsDto bookDetailsDto) {
        return new Book(
                bookDetailsDto.getId(),
                bookDetailsDto.getYear(),
                bookDetailsDto.getTitlePl(),
                bookDetailsDto.getTitleEn(),
                bookDetailsDto.getSeries(),
                bookDetailsDto.getGenre(),
                getAuthorsByBook(bookDetailsDto.getId()),
                myScoreMapper.mapToMyScore(bookDetailsDto.getMyScore()),
                worldScoreMapper.mapToWorldScore(bookDetailsDto.getWorldScore()),
                homeCollectionMapper.mapToHomeCollection(bookDetailsDto.getHomeCollection())
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
                mapToAuthorsDto(book.getAuthors()),
                myScoreMapper.mapToMyScoreDto(book.getMyScore()),
                worldScoreMapper.mapToWorldScoreDto(book.getWorldScore()),
                homeCollectionMapper.mapToHomeCollectionDto(book.getHomeCollection())
        );
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
                        mapToAuthorsDto(b.getAuthors()),
                        myScoreMapper.mapToMyScoreDto(b.getMyScore()),
                        worldScoreMapper.mapToWorldScoreDto(b.getWorldScore()),
                        homeCollectionMapper.mapToHomeCollectionDto(b.getHomeCollection())))
                .collect(Collectors.toList());
    }

    private BookDetailsDto.AuthorDto mapToAuthorDto(Author author) {
        return new BookDetailsDto.AuthorDto(author.getId(), author.getName(), author.getSurname());
    }

    private List<BookDetailsDto.AuthorDto> mapToAuthorsDto(List<Author> authors) {
        return authors.stream()
                .map(this::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    private List<Author> getAuthorsByBook(long bookId) {
        return service.getBook(bookId).orElseThrow(ItemNotFoundException::new).getAuthors();
    }
}
