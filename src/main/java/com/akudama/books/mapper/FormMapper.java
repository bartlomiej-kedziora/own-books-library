package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.FormDto.FormDtoBuilder.aFormDtoBuilder;

import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.domain.entity.Form;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {

    public Form mapToForm(final FormDto formDto) {
        return new Form(
                formDto.getId(),
                formDto.getValue()
        );
    }

    public List<Form> mapToFormList(final List<FormDto> formDtoList) {
        return formDtoList.stream()
                .map(this::mapToForm)
                .collect(Collectors.toList());
    }

    public FormDto mapToFormDto(final Form form) {
        return aFormDtoBuilder()
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
