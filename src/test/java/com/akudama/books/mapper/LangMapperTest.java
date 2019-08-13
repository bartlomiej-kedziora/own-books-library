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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class LangMapperTest {
    private LangDto langDto = LangDto.LangDtoBuilder.alangDtoBuilder()
            .withId(1L)
            .withValue(LangKind.EN)
            .withHomeCollectionItem(createHomeCollectionItemDto())
            .build();
    private Lang lang = new Lang(1L, LangKind.EN, createHomeCollectionItem());

    @Autowired
    private LangMapper langMapper;

    @Test
    public void shouldMapToLang() {
        //When
        Lang lang = langMapper.mapToLang(langDto);

        //Then
        assertEquals(Numbers.ONE, lang.getId());
        assertEquals(LangKind.EN, lang.getValue());
    }

    @Test
    public void shouldMapToLangList() {
        //Given
        List<LangDto> langDtos = Arrays.asList(langDto);

        //When
        List<Lang> langs = langMapper.mapToLangList(langDtos);

        //Then
        assertEquals(1, langs.size());
        assertEquals(Numbers.ONE, langs.get(0).getId());
        assertEquals(LangKind.EN, langs.get(0).getValue());
    }

    @Test
    public void shouldMapToLangDto() {
        //When
        LangDto langDto = langMapper.mapToLangDto(lang);

        //Then
        assertEquals(Numbers.ONE, langDto.getId());
        assertEquals(LangKind.EN, langDto.getValue());
    }

    @Test
    public void shouldMapToLangDtoList() {
        //Given
        List<Lang> langs = Arrays.asList(lang);

        //When
        List<LangDto> langDtos = langMapper.mapToLangDtoList(langs);

        //Then
        assertEquals(1, langDtos.size());
        assertEquals(Numbers.ONE, langDtos.get(0).getId());
        assertEquals(LangKind.EN, langDtos.get(0).getValue());
    }

    private HomeCollectionItem createHomeCollectionItem() {
        Book book = new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");
        HomeCollection homeCollection = new HomeCollection(1L, new User(), new ArrayList<>());
        HomeCollectionItem homeCollectionItem = new HomeCollectionItem();
        List<Form> forms = Arrays.asList(new Form(1L, BookKind.EBOOK, homeCollectionItem));
        List<Lang> langs = Arrays.asList(new Lang(1L, LangKind.EN, homeCollectionItem));
        MyScore myScore = new MyScore(1L, 5);

        return new HomeCollectionItem(1L, book, homeCollection, myScore, forms, langs);
    }

    private HomeCollectionItemDto createHomeCollectionItemDto() {
        BookDto bookDto = BookDto.BookDtoBuilder.aBookDtoBuilder()
                .withId(1L)
                .withYear(1976)
                .withTitlePl("Manitu")
                .withTitleEn("Manitou")
                .withSeries("manitou")
                .withGenre("horror")
                .build();
        UserDto userDto = UserDto.UserDtoBuilder.aUserDtoBuilder().build();
        HomeCollectionDto homeCollectionDto = HomeCollectionDto.HomeCollectionDtoBuilder.aHomeCollectionDtoBuilder()
                .withId(1L)
                .withUser(userDto)
                .withHomeCollectionItems(new ArrayList<>())
                .build();
        ScoreDto myScoreDto = ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder()
                .withId(1L)
                .withValue(5)
                .build();
        HomeCollectionItemDto homeCollectionItemDto = HomeCollectionItemDto.HomeCollectionItemDtoBuilder
                .aHomeCollectionItemDtoBuilder().build();
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

        return HomeCollectionItemDto.HomeCollectionItemDtoBuilder.aHomeCollectionItemDtoBuilder()
                .withId(1L)
                .withBook(bookDto)
                .withHomeCollection(homeCollectionDto)
                .withMyScore(myScoreDto)
                .withForms(formDtos)
                .withLangs(langDtos)
                .build();
    }
}
