package com.akudama.books.mapper;

import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.entity.HomeCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HomeCollectionMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HomeCollectionItemMapper homeCollectionItemMapper;

    public HomeCollection mapToHomeCollection(final HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                userMapper.mapToUser(homeCollectionDto.getUser()),
                homeCollectionItemMapper.mapToHomeCollectionItemList(homeCollectionDto.getHomeCollectionItems())
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(final HomeCollection homeCollection) {
        return new HomeCollectionDto(
                homeCollection.getId(),
                userMapper.mapToUserDto(homeCollection.getUser()),
                homeCollectionItemMapper.mapToHomeCollectionItemDtoList(homeCollection.getHomeCollectionItems())
        );
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(final List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(h -> new HomeCollectionDto(
                        h.getId(),
                        userMapper.mapToUserDto(h.getUser()),
                        homeCollectionItemMapper.mapToHomeCollectionItemDtoList(h.getHomeCollectionItems())))
                .collect(Collectors.toList());
    }
}
