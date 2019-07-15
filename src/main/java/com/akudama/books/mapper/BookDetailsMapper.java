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
    private WorldScoreMapper worldScoreMapper;
    @Autowired
    private HomeCollectionItemMapper homeCollectionItemMapper;

    public Book mapToBook(final BookDetailsDto bookDetailsDto) {
        return new Book(
                bookDetailsDto.getId(),
                bookDetailsDto.getYear(),
                bookDetailsDto.getTitlePl(),
                bookDetailsDto.getTitleEn(),
                bookDetailsDto.getSeries(),
                bookDetailsDto.getGenre(),
                mapToAuthor(bookDetailsDto.getAuthors()),
                worldScoreMapper.mapToWorldScore(bookDetailsDto.getWorldScore()),
                homeCollectionItemMapper.mapToHomeCollectionItemList(bookDetailsDto.getHomeCollectionItems())
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
                worldScoreMapper.mapToWorldScoreDto(book.getWorldScore()),
                homeCollectionItemMapper.mapToHomeCollectionItemDtoList(book.getHomeCollectionItems())
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
                        worldScoreMapper.mapToWorldScoreDto(b.getWorldScore()),
                        homeCollectionItemMapper.mapToHomeCollectionItemDtoList(b.getHomeCollectionItems())))
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
