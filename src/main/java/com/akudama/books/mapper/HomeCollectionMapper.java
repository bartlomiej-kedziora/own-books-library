package com.akudama.books.mapper;

import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.dto.HomeCollectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HomeCollectionMapper {
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private  LangMapper langMapper;

    public HomeCollection mapToHomeCollection(final HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                formMapper.mapToFormList(homeCollectionDto.getForms()),
                langMapper.mapToLangList(homeCollectionDto.getLangs())
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(final HomeCollection homeCollection) {
        return new HomeCollectionDto(
                homeCollection.getId(),
                formMapper.mapToFormDtoList(homeCollection.getForms()),
                langMapper.mapToLangDtoList(homeCollection.getLangs())
        );
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(final List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(h -> new HomeCollectionDto(
                        h.getId(),
                        formMapper.mapToFormDtoList(h.getForms()),
                        langMapper.mapToLangDtoList(h.getLangs())))
                .collect(Collectors.toList());
    }
}
