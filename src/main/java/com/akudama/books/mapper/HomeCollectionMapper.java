package com.akudama.books.mapper;

import com.akudama.books.domain.HomeCollection;
import com.akudama.books.domain.HomeCollectionDto;

import java.util.List;
import java.util.stream.Collectors;

public class HomeCollectionMapper {
    public HomeCollection mapToHomeCollection(HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                homeCollectionDto.getForms(),
                homeCollectionDto.getLangs()
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(HomeCollection homeCollection) {
        return new HomeCollectionDto(
                homeCollection.getId(),
                homeCollection.getForms(),
                homeCollection.getLangs()
        );
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(h -> new HomeCollectionDto(
                        h.getId(),
                        h.getForms(),
                        h.getLangs()))
                .collect(Collectors.toList());
    }
}
