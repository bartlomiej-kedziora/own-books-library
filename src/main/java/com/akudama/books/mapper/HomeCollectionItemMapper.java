package com.akudama.books.mapper;

import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.HomeCollectionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HomeCollectionItemMapper {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private HomeCollectionMapper homeCollectionMapper;
    @Autowired
    private MyScoreMapper myScoreMapper;
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private LangMapper langMapper;

    public HomeCollectionItem mapToHomeCollectionItem(final HomeCollectionItemDto homeCollectionItemDto) {
        return new HomeCollectionItem(
                homeCollectionItemDto.getId(),
                bookMapper.mapToBook(homeCollectionItemDto.getBook()),
                homeCollectionMapper.mapToHomeCollection(homeCollectionItemDto.getHomeCollection()),
                myScoreMapper.mapToMyScore(homeCollectionItemDto.getMyScore()),
                formMapper.mapToFormList(homeCollectionItemDto.getForms()),
                langMapper.mapToLangList(homeCollectionItemDto.getLangs())
        );
    }

    public List<HomeCollectionItem> mapToHomeCollectionItemList(final List<HomeCollectionItemDto> homeCollectionItemDtoList) {
        return homeCollectionItemDtoList.stream()
                .map(this::mapToHomeCollectionItem)
                .collect(Collectors.toList());
    }

    public HomeCollectionItemDto mapToHomeCollectionItemDto(final HomeCollectionItem homeCollectionItem) {
        return HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder()
                .withId(homeCollectionItem.getId())
                .withBook(bookMapper.mapToBookDto(homeCollectionItem.getBook()))
                .withHomeCollection(homeCollectionMapper.mapToHomeCollectionDto(homeCollectionItem.getHomeCollection()))
                .withMyScore(myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()))
                .withForms(formMapper.mapToFormDtoList(homeCollectionItem.getForms()))
                .withLangs(langMapper.mapToLangDtoList(homeCollectionItem.getLangs()))
                .build();
    }

    public List<HomeCollectionItemDto> mapToHomeCollectionItemDtoList(final List<HomeCollectionItem> homeCollectionItemList) {
        return homeCollectionItemList.stream()
                .map(this::mapToHomeCollectionItemDto)
                .collect(Collectors.toList());
    }
}
