package com.akudama.books.mapper;

import com.akudama.books.domain.Lang;
import com.akudama.books.domain.LangDto;

import java.util.List;
import java.util.stream.Collectors;

public class LangMapper {
    public Lang mapToLang(LangDto langDto) {
        return new Lang(
                langDto.getId(),
                langDto.getValue(),
                langDto.getHomeCollection()
        );
    }

    public LangDto mapToLangDto(Lang lang) {
        return new LangDto(
                lang.getId(),
                lang.getValue(),
                lang.getHomeCollection()
        );
    }

    public List<LangDto> mapToLangDtoList(List<Lang> langList) {
        return langList.stream()
                .map(l -> new LangDto(
                        l.getId(),
                        l.getValue(),
                        l.getHomeCollection()))
                .collect(Collectors.toList());
    }
}
