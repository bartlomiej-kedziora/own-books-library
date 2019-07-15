package com.akudama.books.mapper;

import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.entity.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LangMapper {
    @Autowired
    private HomeCollectionItemMapper homeCollectionItemMapper;

    public Lang mapToLang(final LangDto langDto) {
        return new Lang(
                langDto.getId(),
                langDto.getValue(),
                homeCollectionItemMapper.mapToHomeCollectionItem(langDto.getHomeCollectionItem())
        );
    }

    public List<Lang> mapToLangList(final List<LangDto> langDtoList) {
        return langDtoList.stream()
                .map(l -> new Lang(
                        l.getId(),
                        l.getValue(),
                        homeCollectionItemMapper.mapToHomeCollectionItem(l.getHomeCollectionItem())))
                .collect(Collectors.toList());
    }

    public LangDto mapToLangDto(final Lang lang) {
        return new LangDto(
                lang.getId(),
                lang.getValue(),
                homeCollectionItemMapper.mapToHomeCollectionItemDto(lang.getHomeCollectionItem())
        );
    }

    public List<LangDto> mapToLangDtoList(final List<Lang> langList) {
        return langList.stream()
                .map(l -> new LangDto(
                        l.getId(),
                        l.getValue(),
                        homeCollectionItemMapper.mapToHomeCollectionItemDto(l.getHomeCollectionItem())))
                .collect(Collectors.toList());
    }
}
