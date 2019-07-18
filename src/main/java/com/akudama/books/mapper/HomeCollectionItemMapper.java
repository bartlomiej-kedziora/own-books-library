package com.akudama.books.mapper;

import com.akudama.books.domain.dto.BookDetailsDto;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.HomeCollectionItem;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeCollectionItemMapper {

    @Autowired
    private BookDetailsMapper bookMapper;
    @Autowired
    private MyScoreMapper myScoreMapper;
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private LangMapper langMapper;

    public HomeCollectionItem mapToHomeCollectionItem(
            final HomeCollectionItemDto homeCollectionItemDto) {
        return new HomeCollectionItem(
                homeCollectionItemDto.getId(),
                bookMapper.mapToBook(homeCollectionItemDto.getBook()),
                myScoreMapper.mapToMyScore(homeCollectionItemDto.getMyScore()),
                formMapper.mapToFormList(homeCollectionItemDto.getForms()),
                langMapper.mapToLangList(homeCollectionItemDto.getLangs())
        );
    }

    public List<HomeCollectionItem> mapToHomeCollectionItemList(
            final List<HomeCollectionItemDto> homeCollectionItemDtoList) {
        return homeCollectionItemDtoList.stream()
                .map(this::mapToHomeCollectionItem)
                .collect(Collectors.toList());
    }

    public HomeCollectionItemDto mapToHomeCollectionItemDto(
            final HomeCollectionItem homeCollectionItem) {
        return HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder()
                .withId(homeCollectionItem.getId())
                .withBook(mapToBookDto(homeCollectionItem.getBook()))
                .withMyScore(myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()))
                .withForms(formMapper.mapToFormDtoList(homeCollectionItem.getForms()))
                .withLangs(langMapper.mapToLangDtoList(homeCollectionItem.getLangs()))
                .build();
    }

    public List<HomeCollectionItemDto> mapToHomeCollectionItemDtoList(
            final List<HomeCollectionItem> homeCollectionItemList) {
        return homeCollectionItemList.stream()
                .map(this::mapToHomeCollectionItemDto)
                .collect(Collectors.toList());
    }

    private BookDetailsDto mapToBookDto(Book book) {
        return BookDetailsDto.BookDetailsDtoBuilder.aBookDetailsDtoBuilder()
                .withBookDto(
                        BookDto.BookDtoBuilder.aBookDtoBuilder()
                                .withId(book.getId())
                                .withYear(book.getYear())
                                .withTitlePl(book.getTitlePl())
                                .withTitleEn(book.getTitleEn())
                                .withSeries(book.getSeries())
                                .withGenre(book.getGenre())
                                .build())
                .build();

    }

    private List<BookDetailsDto> mapToBooksDto(List<Book> books) {
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
