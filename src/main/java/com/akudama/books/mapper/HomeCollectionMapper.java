package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.HomeCollectionDto.HomeCollectionDtoBuilder.aHomeCollectionDtoBuilder;

import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.entity.HomeCollection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeCollectionMapper {

    private UserMapper userMapper;
    private HomeCollectionItemMapper homeCollectionItemMapper;

    @Autowired
    public HomeCollectionMapper(UserMapper userMapper,
            HomeCollectionItemMapper homeCollectionItemMapper) {
        this.userMapper = userMapper;
        this.homeCollectionItemMapper = homeCollectionItemMapper;
    }

    public HomeCollection mapToHomeCollection(final HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                userMapper.mapToUser(homeCollectionDto.getUser()),
                homeCollectionItemMapper
                        .mapToHomeCollectionItemList(homeCollectionDto.getHomeCollectionItems())
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(final HomeCollection homeCollection) {
        return aHomeCollectionDtoBuilder()
                .withId(homeCollection.getId())
                .withUser(userMapper.mapToUserDto(homeCollection.getUser()))
                .withHomeCollectionItems(
                        homeCollectionItemMapper.mapToHomeCollectionItemDetailsDtoList(
                                homeCollection.getHomeCollectionItems())
                )
                .build();
    }

    public List<HomeCollectionDto> mapToHomeCollectionDtoList(
            final List<HomeCollection> homeCollectionList) {
        return homeCollectionList.stream()
                .map(this::mapToHomeCollectionDto)
                .collect(Collectors.toList());
    }
}
