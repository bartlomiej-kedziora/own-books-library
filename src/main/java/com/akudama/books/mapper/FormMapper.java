package com.akudama.books.mapper;

import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.domain.entity.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormMapper {
    private final HomeCollectionItemMapper homeCollectionItemMapper;

    @Autowired
    public FormMapper(HomeCollectionItemMapper homeCollectionItemMapper) {
        this.homeCollectionItemMapper = homeCollectionItemMapper;
    }

    public Form mapToForm(final FormDto formDto) {
        return new Form(
                formDto.getId(),
                formDto.getValue(),
                homeCollectionItemMapper.mapToHomeCollectionItem(formDto.getHomeCollectionItem())
        );
    }

    public List<Form> mapToFormList(final List<FormDto> formDtoList) {
        return formDtoList.stream()
                .map(this::mapToForm)
                .collect(Collectors.toList());
    }

    public FormDto mapToFormDto(final Form form) {
        return FormDto.FormDtoBuilder.aFormDtoBuilder()
                .withId(form.getId())
                .withValue(form.getValue())
                .build();
    }

    public List<FormDto> mapToFormDtoList(final List<Form> formList) {
        return formList.stream()
                .map(this::mapToFormDto)
                .collect(Collectors.toList());
    }
}
