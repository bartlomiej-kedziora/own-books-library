package com.akudama.books.mapper;

import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BookDetailsMapper {
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
                mapToAuthor(bookDetailsDto.getAuthors()),
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
                .collect(toList());
    }

    private AuthorDto mapToAuthorDto(Author author) {
        return new AuthorDto(author.getId(), author.getYearOfBirth(), author.getName(), author.getSurname(), author.getCity(), author.getCountry());
    }

    private List<AuthorDto> mapToAuthorsDto(List<Author> authors) {
        return authors.stream()
                .map(this::mapToAuthorDto)
                .collect(toList());
    }

    private List<Author> mapToAuthor(List<AuthorDto> authorDtos) {
        return authorDtos.stream()
                .map(authorDto -> new Author(authorDto.getId(), authorDto.getYearOfBirth(), authorDto.getName(), authorDto.getSurname(), authorDto.getCity(), authorDto.getCountry()))
                .collect(toList());
    }
}
