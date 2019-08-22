package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.BookDetailsDto.BookDetailsDtoBuilder.aBookDetailsDtoBuilder;
import static java.util.stream.Collectors.toList;

import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.entity.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsMapper {

    private WorldScoreMapper worldScoreMapper;
    private BookMapper bookMapper;
    private AuthorMapper authorMapper;

    @Autowired
    public BookDetailsMapper(WorldScoreMapper worldScoreMapper, BookMapper bookMapper,
            AuthorMapper authorMapper) {
        this.worldScoreMapper = worldScoreMapper;
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
    }

    public Book mapToBook(final BookDetailsDto bookDetailsDto) {
        return new Book(
//                bookDetailsDto.getBookDto().getId(),
                bookDetailsDto.getBookDto().getYear(),
                bookDetailsDto.getBookDto().getTitlePl(),
                bookDetailsDto.getBookDto().getTitleEn(),
                bookDetailsDto.getBookDto().getSeries(),
                bookDetailsDto.getBookDto().getGenre(),
                authorMapper.mapToAuthorList(bookDetailsDto.getAuthors()),
                worldScoreMapper.mapToWorldScore(bookDetailsDto.getWorldScore())
        );
    }

    public BookDetailsDto mapToBookDto(final Book book) {
        return aBookDetailsDtoBuilder()
                .withBookDto(bookMapper.mapToBookDto(book))
                .build();
    }

    public BookDetailsDto mapToBookDetailsDto(final Book book) {
        return aBookDetailsDtoBuilder()
                .withBookDto(bookMapper.mapToBookDto(book))
                .withAuthors(authorMapper.mapToAuthorDtoList(book.getAuthors()))
                .withWorldScore(worldScoreMapper.mapToWorldScoreDto(book.getWorldScore()))
                .build();
    }

    public List<BookDetailsDto> mapToBookDetailsDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDetailsDto)
                .collect(toList());
    }
}
