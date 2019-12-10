package com.akudama.books.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public ModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, E> E convertToEntity(final T dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <T, E> List<E> convertToEntityList(final List<T> dto, Class<E> entityClass) {
        return dto.stream()
                .map(e -> convertToDto(e, entityClass))
                .collect(Collectors.toList());
    }

    public <T, E> T convertToDto(final E entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <T, E> List<T> convertToDtoList(final List<E> entity, Class<T> dtoClass) {
        return entity.stream()
                .map(e -> convertToDto(e, dtoClass))
                .collect(Collectors.toList());
    }

    public <T, E> Set<T> convertToDtoSet(final Set<E> entity, Class<T> dtoClass) {
        return entity.stream()
                .map(e -> convertToDto(e, dtoClass))
                .collect(Collectors.toSet());
    }
}
