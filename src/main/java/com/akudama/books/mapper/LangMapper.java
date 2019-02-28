package com.akudama.books.mapper;

import com.akudama.books.domain.entity.Lang;
import com.akudama.books.domain.dto.LangDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LangMapper {
    @Autowired
    private HomeCollectionMapper homeCollectionMapper;

    public Lang mapToLang(final LangDto langDto) {
        return new Lang(
                langDto.getId(),
                langDto.getValue(),
                homeCollectionMapper.mapToHomeCollection(langDto.getHomeCollection())
        );
    }

    public List<Lang> mapToLangList(final List<LangDto> langDtoList) {
        return langDtoList.stream()
                .map(l -> new Lang(
                        l.getId(),
                        l.getValue(),
                        homeCollectionMapper.mapToHomeCollection(l.getHomeCollection())))
                .collect(Collectors.toList());
    }

    public LangDto mapToLangDto(final Lang lang) {
        return new LangDto(
                lang.getId(),
                lang.getValue(),
                homeCollectionMapper.mapToHomeCollectionDto(lang.getHomeCollection())
        );
    }

    public List<LangDto> mapToLangDtoList(final List<Lang> langList) {
        return langList.stream()
                .map(l -> new LangDto(
                        l.getId(),
                        l.getValue(),
                        homeCollectionMapper.mapToHomeCollectionDto(l.getHomeCollection())))
                .collect(Collectors.toList());
    }
}
