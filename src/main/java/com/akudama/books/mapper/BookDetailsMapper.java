package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder;
import static java.util.stream.Collectors.toList;

import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.HomeCollectionItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDetailsMapper {
    @Autowired
    private WorldScoreMapper worldScoreMapper;
    @Autowired
    private HomeCollectionItemMapper homeCollectionItemMapper;
    @Autowired
    private MyScoreMapper myScoreMapper;
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private LangMapper langMapper;

    public Book mapToBook(final BookDetailsDto bookDetailsDto) {
        return new Book(
                bookDetailsDto.getBookDto().getId(),
                bookDetailsDto.getBookDto().getYear(),
                bookDetailsDto.getBookDto().getTitlePl(),
                bookDetailsDto.getBookDto().getTitleEn(),
                bookDetailsDto.getBookDto().getSeries(),
                bookDetailsDto.getBookDto().getGenre(),
                mapToAuthor(bookDetailsDto.getAuthors()),
                worldScoreMapper.mapToWorldScore(bookDetailsDto.getWorldScore())
        );
    }

    public BookDetailsDto mapToBookDetailsDto(final Book book) {
        return BookDetailsDto.BookDetailsDtoBuilder.aBookDetailsDtoBuilder()
                .withBookDto(BookDto.BookDtoBuilder.aBookDtoBuilder()
                        .withId(book.getId())
                        .withYear(book.getYear())
                        .withTitlePl(book.getTitlePl())
                        .withTitleEn(book.getTitleEn())
                        .withSeries(book.getSeries())
                        .withGenre(book.getGenre())
                        .build())
                .withAuthors(mapToAuthorsDto(book.getAuthors()))
                .withWorldScore(worldScoreMapper.mapToWorldScoreDto(book.getWorldScore()))
                .build();
    }

    public List<BookDetailsDto> mapToBookDetailsDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDetailsDto)
                .collect(toList());
    }

    private AuthorDto mapToAuthorDto(Author author) {
        return AuthorDto.AuthorDtoBuilder.aAuthorDtoBuilder()
                .withId(author.getId())
                .withYearOfBirth(author.getYearOfBirth())
                .withName(author.getName())
                .withSurname(author.getSurname())
                .withCity(author.getCity())
                .withCountry(author.getCountry())
                .build();
    }

    private List<AuthorDto> mapToAuthorsDto(List<Author> authors) {
        return authors.stream()
                .map(this::mapToAuthorDto)
                .collect(toList());
    }

    private List<Author> mapToAuthor(List<AuthorDto> authorDtos) {
        return authorDtos.stream()
                .map(authorDto -> new Author(authorDto.getId(), authorDto.getYearOfBirth(),
                        authorDto.getName(), authorDto.getSurname(), authorDto.getCity(),
                        authorDto.getCountry()))
                .collect(toList());
    }

    private HomeCollectionItemDto mapToHomeCollectionItemDto(
            HomeCollectionItem homeCollectionItem) {
        return aHomeCollectionItemDtoBuilder()
                .withId(homeCollectionItem.getId())
                .withForms(formMapper.mapToFormDtoList(homeCollectionItem.getForms()))
                .withLangs(langMapper.mapToLangDtoList(homeCollectionItem.getLangs()))
                .withMyScore(myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()))
                .build();
    }

    private List<HomeCollectionItemDto> mapToHomeCollectionItemsDto(
            List<HomeCollectionItem> homeCollectionItems) {
        return homeCollectionItems.stream()
                .map(this::mapToHomeCollectionItemDto)
                .collect(toList());
    }

    private List<HomeCollectionItem> mapToHomeCollectionItemList(
            List<HomeCollectionItemDto> homeCollectionItemDtos) {
        return homeCollectionItemDtos.stream()
                .map(h -> new HomeCollectionItem(
                        h.getId(),
                        myScoreMapper.mapToMyScore(h.getMyScore()),
                        formMapper.mapToFormList(h.getForms()),
                        langMapper.mapToLangList(h.getLangs()))
                )
                .collect(toList());
    }
}
