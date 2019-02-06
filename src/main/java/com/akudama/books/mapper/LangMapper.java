package com.akudama.books.mapper;

import com.akudama.books.domain.entity.Lang;
import com.akudama.books.domain.dto.LangDto;

import java.util.List;
import java.util.stream.Collectors;

public class LangMapper {
    public Lang mapToLang(final LangDto langDto) {
        return new Lang(
                langDto.getId(),
                langDto.getValue(),
                langDto.getHomeCollection()
        );
    }

    public LangDto mapToLangDto(final Lang lang) {
        return new LangDto(
                lang.getId(),
                lang.getValue(),
                lang.getHomeCollection()
        );
    }

    public List<LangDto> mapToLangDtoList(final List<Lang> langList) {
        return langList.stream()
                .map(l -> new LangDto(
                        l.getId(),
                        l.getValue(),
                        l.getHomeCollection()))
                .collect(Collectors.toList());
    }
}
