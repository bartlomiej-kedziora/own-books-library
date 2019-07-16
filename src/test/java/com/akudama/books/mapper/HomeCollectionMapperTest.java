package com.akudama.books.mapper;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.BookDto;
import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.domain.entity.Lang;
import com.akudama.books.domain.entity.MyScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeCollectionMapperTest {

    @Autowired
    private HomeCollectionItemMapper homeCollectionItemMapper;

    @Test
    public void shouldMapToHomeCollection() {
        //Given
        HomeCollectionItemDto homeCollectionItemDto = createHomeCollectionItemDto();

        //When
        HomeCollectionItem homeCollectionItem = homeCollectionItemMapper.mapToHomeCollectionItem(homeCollectionItemDto);

        //Then
        assertEquals(Numbers.ONE, homeCollectionItem.getId());
        assertEquals(Numbers.ONE, homeCollectionItem.getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollectionItem.getForms().get(0).getValue());
        assertEquals(Numbers.ONE, homeCollectionItem.getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollectionItem.getLangs().get(0).getValue());
    }

    @Test
    public void shouldMapToHomeCollectionDto() {
        //Given
        HomeCollectionItem homeCollectionItem = createHomeCollectionItem();

        //When
        HomeCollectionItemDto homeCollectionItemDto = homeCollectionItemMapper.mapToHomeCollectionItemDto(homeCollectionItem);

        //Then
        assertEquals(Numbers.ONE, homeCollectionItemDto.getId());
        assertEquals(1, homeCollectionItemDto.getForms().size());
        assertEquals(Numbers.ONE, homeCollectionItemDto.getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollectionItemDto.getForms().get(0).getValue());
        assertEquals(1, homeCollectionItemDto.getLangs().size());
        assertEquals(Numbers.ONE, homeCollectionItemDto.getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollectionItemDto.getLangs().get(0).getValue());
    }

    @Test
    public void shouldMapToHomeCollectionDtoList() {
        //Given
        List<HomeCollectionItem> homeCollectionItems = Arrays.asList(createHomeCollectionItem());

        //When
        List<HomeCollectionItemDto> homeCollectionItemDtos = homeCollectionItemMapper.mapToHomeCollectionItemDtoList(homeCollectionItems);

        //Then
        assertEquals(1, homeCollectionItemDtos.size());
        assertEquals(Numbers.ONE, homeCollectionItemDtos.get(0).getId());
        assertEquals(1, homeCollectionItemDtos.get(0).getForms().size());
        assertEquals(Numbers.ONE, homeCollectionItemDtos.get(0).getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollectionItemDtos.get(0).getForms().get(0).getValue());
        assertEquals(1, homeCollectionItemDtos.get(0).getLangs().size());
        assertEquals(Numbers.ONE, homeCollectionItemDtos.get(0).getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollectionItemDtos.get(0).getLangs().get(0).getValue());
    }

    private HomeCollectionItem createHomeCollectionItem() {

        HomeCollectionItem homeCollectionItem = new HomeCollectionItem();
        List<Form> forms = Arrays.asList(new Form(1L, BookKind.EBOOK, homeCollectionItem));
        List<Lang> langs = Arrays.asList(new Lang(1L, LangKind.EN, homeCollectionItem));
        MyScore myScore = new MyScore(1L, 5);

        return new HomeCollectionItem(1L, new Book(), new HomeCollection(), myScore, forms, langs);
    }

    private HomeCollectionItemDto createHomeCollectionItemDto() {
        HomeCollectionItemDto homeCollectionItemDto = HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder()
                .build();
        List<FormDto> formDtos = Arrays.asList(FormDto.FormDtoBuilder.aFormDtoBuilder()
                .withId(1L)
                .withValue(BookKind.EBOOK)
                .withHomeCollectionItem(homeCollectionItemDto)
                .build());
        List<LangDto> langDtos = Arrays.asList(LangDto.LangDtoBuilder.alangDtoBuilder()
                .withId(1L)
                .withValue(LangKind.EN)
                .withHomeCollectionItem(homeCollectionItemDto)
                .build());
        ScoreDto myScoreDto = ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder()
                .withId(1L)
                .withValue(5)
                .build();
        BookDto bookDto = BookDto.BookDtoBuilder.aBookDtoBuilder().build();
        HomeCollectionDto homeCollectionDto = HomeCollectionDto.HomeCollectionDtoBuilder.aHomeCollectionDtoBuilder().build();

        return HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder().withId(1L)
                .withBook(bookDto)
                .withHomeCollection(homeCollectionDto)
                .withMyScore(myScoreDto)
                .withForms(formDtos)
                .withLangs(langDtos)
                .build();
    }
}
