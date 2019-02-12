package com.akudama.books.mapper;

import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.HomeCollectionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HomeCollectionMapper {
    public HomeCollection mapToHomeCollection(final HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                homeCollectionDto.getForms(),
                homeCollectionDto.getLangs()
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(final HomeCollection homeCollection) {
        return new HomeCollectionDto(
                homeCollection.getId(),
                homeCollection.getForms(),
                homeCollection.getLangs()
        );
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(final List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(h -> new HomeCollectionDto(
                        h.getId(),
                        h.getForms(),
                        h.getLangs()))
                .collect(Collectors.toList());
    }
}
