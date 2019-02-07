package com.akudama.books.mapper;

import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.dto.FormDto;

import java.util.List;
import java.util.stream.Collectors;

public class FormMapper {
    public Form mapToForm(final FormDto formDto) {
        return new Form(
                formDto.getId(),
                formDto.getValue(),
                formDto.getHomeCollection()
        );
    }

    public FormDto mapToFormDto(final Form form) {
        return new FormDto(
                form.getId(),
                form.getValue(),
                form.getHomeCollection()
        );
    }

    public List<FormDto> mapToFormDtoList(final List<Form> formList) {
        return formList.stream()
                .map(f -> new FormDto(
                        f.getId(),
                        f.getValue(),
                        f.getHomeCollection()))
                .collect(Collectors.toList());
    }
}
