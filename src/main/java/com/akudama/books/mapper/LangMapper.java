package com.akudama.books.mapper;

import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.entity.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LangMapper {

    public Lang mapToLang(final LangDto langDto) {
        return new Lang(
                langDto.getId(),
                langDto.getValue()
        );
    }

    public List<Lang> mapToLangList(final List<LangDto> langDtoList) {
        return langDtoList.stream()
                .map(this::mapToLang)
                .collect(Collectors.toList());
    }

    public LangDto mapToLangDto(final Lang lang) {
        return LangDto.LangDtoBuilder.alangDtoBuilder()
                .withId(lang.getId())
                .withValue(lang.getValue())
                .build();
    }

    public List<LangDto> mapToLangDtoList(final List<Lang> langList) {
        return langList.stream()
                .map(this::mapToLangDto)
                .collect(Collectors.toList());
    }
}
