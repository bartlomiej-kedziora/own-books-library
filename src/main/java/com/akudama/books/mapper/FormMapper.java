package com.akudama.books.mapper;

import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.dto.FormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FormMapper {
    @Autowired
    private HomeCollectionMapper homeCollectionMapper;

    public Form mapToForm(final FormDto formDto) {
        return new Form(
                formDto.getId(),
                formDto.getValue(),
                homeCollectionMapper.mapToHomeCollection(formDto.getHomeCollection())
        );
    }

    public List<Form> mapToFormList(final List<FormDto> formDtoList) {
        return formDtoList.stream()
                .map(f -> new Form(
                        f.getId(),
                        f.getValue(),
                        homeCollectionMapper.mapToHomeCollection(f.getHomeCollection())))
                .collect(Collectors.toList());
    }

    public FormDto mapToFormDto(final Form form) {
        return new FormDto(
                form.getId(),
                form.getValue(),
                homeCollectionMapper.mapToHomeCollectionDto(form.getHomeCollection())
        );
    }

    public List<FormDto> mapToFormDtoList(final List<Form> formList) {
        return formList.stream()
                .map(f -> new FormDto(
                        f.getId(),
                        f.getValue(),
                        homeCollectionMapper.mapToHomeCollectionDto(f.getHomeCollection())))
                .collect(Collectors.toList());
    }
}
