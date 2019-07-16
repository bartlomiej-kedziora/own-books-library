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
        return HomeCollectionDto.HomeCollectionDtoBuilder.aHomeCollectionDtoBuilder()
                .withId(homeCollection.getId())
                .withUser(userMapper.mapToUserDto(homeCollection.getUser()))
                .withHomeCollectionItems(homeCollectionItemMapper.mapToHomeCollectionItemDtoList(
                        homeCollection.getHomeCollectionItems())
                )
                .build();
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(final List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(this::mapToHomeCollectionDto)
                .collect(Collectors.toList());
    }
}
