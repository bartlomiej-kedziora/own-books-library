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
                .map(h -> new HomeCollectionItem(
                        h.getId(),
                        bookMapper.mapToBook(h.getBook()),
                        homeCollectionMapper.mapToHomeCollection(h.getHomeCollection()),
                        myScoreMapper.mapToMyScore(h.getMyScore()),
                        formMapper.mapToFormList(h.getForms()),
                        langMapper.mapToLangList(h.getLangs())))
                .collect(Collectors.toList());
    }

    public HomeCollectionItemDto mapToHomeCollectionItemDto(final HomeCollectionItem homeCollectionItem) {
        return new HomeCollectionItemDto(
                homeCollectionItem.getId(),
                bookMapper.mapToBookDto(homeCollectionItem.getBook()),
                homeCollectionMapper.mapToHomeCollectionDto(homeCollectionItem.getHomeCollection()),
                myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()),
                formMapper.mapToFormDtoList(homeCollectionItem.getForms()),
                langMapper.mapToLangDtoList(homeCollectionItem.getLangs())
        );
    }

    public List<HomeCollectionItemDto> mapToHomeCollectionItemDtoList(final List<HomeCollectionItem> homeCollectionItemList) {
        return homeCollectionItemList.stream()
                .map(h -> new HomeCollectionItemDto(
                        h.getId(),
                        bookMapper.mapToBookDto(h.getBook()),
                        homeCollectionMapper.mapToHomeCollectionDto(h.getHomeCollection()),
                        myScoreMapper.mapToMyScoreDto(h.getMyScore()),
                        formMapper.mapToFormDtoList(h.getForms()),
                        langMapper.mapToLangDtoList(h.getLangs())))
                .collect(Collectors.toList());
    }
}
