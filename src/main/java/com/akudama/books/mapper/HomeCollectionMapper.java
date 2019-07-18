package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.HomeCollectionDto.HomeCollectionDtoBuilder.aHomeCollectionDtoBuilder;

import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeCollectionMapper {

    private UserMapper userMapper;
    private HomeCollectionItemMapper homeCollectionItemMapper;
    private BookDetailsMapper bookMapper;
    private MyScoreMapper myScoreMapper;
    private FormMapper formMapper;
    private LangMapper langMapper;

    @Autowired
    public HomeCollectionMapper(UserMapper userMapper,
            HomeCollectionItemMapper homeCollectionItemMapper,
            BookDetailsMapper bookMapper, MyScoreMapper myScoreMapper,
            FormMapper formMapper, LangMapper langMapper) {
        this.userMapper = userMapper;
        this.homeCollectionItemMapper = homeCollectionItemMapper;
        this.bookMapper = bookMapper;
        this.myScoreMapper = myScoreMapper;
        this.formMapper = formMapper;
        this.langMapper = langMapper;
    }

    public HomeCollection mapToHomeCollection(final HomeCollectionDto homeCollectionDto) {
        return new HomeCollection(
                homeCollectionDto.getId(),
                userMapper.mapToUser(homeCollectionDto.getUser()),
                mapToHomeCollectionItemList(homeCollectionDto.getHomeCollectionItems())
        );
    }

    public HomeCollectionDto mapToHomeCollectionDto(final HomeCollection homeCollection) {
        return aHomeCollectionDtoBuilder()
                .withId(homeCollection.getId())
                .withUser(userMapper.mapToUserDto(homeCollection.getUser()))
                .withHomeCollectionItems(mapToHomeCollectionItemDtoList(
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

    private HomeCollectionItem mapToHomeCollectionItem(final HomeCollectionItemDto homeCollectionItemDto) {
        return new HomeCollectionItem(
                homeCollectionItemDto.getId(),
                bookMapper.mapToBook(homeCollectionItemDto.getBook()),
                myScoreMapper.mapToMyScore(homeCollectionItemDto.getMyScore()),
                formMapper.mapToFormList(homeCollectionItemDto.getForms()),
                langMapper.mapToLangList(homeCollectionItemDto.getLangs())
        );
    }

    private List<HomeCollectionItem> mapToHomeCollectionItemList(List<HomeCollectionItemDto> homeCollectionItemDtos) {
        return homeCollectionItemDtos.stream()
                .map(this::mapToHomeCollectionItem)
                .collect(Collectors.toList());
    }

    private HomeCollectionItemDto mapToHomeCollectionItemDto(final HomeCollectionItem homeCollectionItem) {
        return new HomeCollectionItemDto(
                homeCollectionItem.getId(),
                bookMapper.mapToBookDetailsDto(homeCollectionItem.getBook()),
                myScoreMapper.mapToMyScoreDto(homeCollectionItem.getMyScore()),
                formMapper.mapToFormDtoList(homeCollectionItem.getForms()),
                langMapper.mapToLangDtoList(homeCollectionItem.getLangs())
        );
    }

    private List<HomeCollectionItemDto> mapToHomeCollectionItemDtoList(List<HomeCollectionItem> homeCollectionItems) {
        return homeCollectionItems.stream()
                .map(this::mapToHomeCollectionItemDto)
                .collect(Collectors.toList());
    }
}
