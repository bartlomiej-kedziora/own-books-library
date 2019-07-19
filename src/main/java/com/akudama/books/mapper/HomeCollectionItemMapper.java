package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder;

import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto.HomeCollectionItemDtoBuilder;
import com.akudama.books.domain.entity.HomeCollectionItem;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeCollectionItemMapper {

    private BookDetailsMapper bookMapper;
    private MyScoreMapper myScoreMapper;
    private FormMapper formMapper;
    private LangMapper langMapper;

    @Autowired
    public HomeCollectionItemMapper(BookDetailsMapper bookMapper,
            MyScoreMapper myScoreMapper, FormMapper formMapper,
            LangMapper langMapper) {
        this.bookMapper = bookMapper;
        this.myScoreMapper = myScoreMapper;
        this.formMapper = formMapper;
        this.langMapper = langMapper;
    }

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
        return mapToHomeCollectionItemDtoBuilder(homeCollectionItem)
                .withBook(bookMapper.mapToBookDto(homeCollectionItem.getBook()))
                .build();
    }

    public List<HomeCollectionItemDto> mapToHomeCollectionItemDtoList(
            final List<HomeCollectionItem> homeCollectionItemList) {
        return homeCollectionItemList.stream()
                .map(this::mapToHomeCollectionItemDto)
                .collect(Collectors.toList());
    }

    public HomeCollectionItemDto mapToHomeCollectionItemDetailsDto(
            final HomeCollectionItem homeCollectionItem) {
        return mapToHomeCollectionItemDtoBuilder(homeCollectionItem)
                .withBook(bookMapper.mapToBookDetailsDto(homeCollectionItem.getBook()))
                .build();
    }

    public List<HomeCollectionItemDto> mapToHomeCollectionItemDetailsDtoList(
            final List<HomeCollectionItem> homeCollectionItemList) {
        return homeCollectionItemList.stream()
                .map(this::mapToHomeCollectionItemDetailsDto)
                .collect(Collectors.toList());
    }

    private HomeCollectionItemDtoBuilder mapToHomeCollectionItemDtoBuilder(
            final HomeCollectionItem homeCollectionItem) {
        return aHomeCollectionItemDtoBuilder()
                .withId(homeCollectionItem.getId())
                .withMyScore(myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()))
                .withForms(formMapper.mapToFormDtoList(homeCollectionItem.getForms()))
                .withLangs(langMapper.mapToLangDtoList(homeCollectionItem.getLangs()));
    }
}
