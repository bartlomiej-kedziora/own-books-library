package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.LangDto.LangDtoBuilder.alangDtoBuilder;

import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.entity.Lang;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

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
        return alangDtoBuilder()
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
