package com.akudama.books.mapper;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.*;
import com.akudama.books.domain.entity.*;
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
//    private LangDto langDto = new LangDto(1L, LangKind.EN, createHomeCollectionItemDto());
//    private Lang lang = new Lang(1L, LangKind.EN, createHomeCollectionItem());

    @Autowired
    private LangMapper langMapper;

//    @Test
//    public void shouldMapToLang() {
//        //When
//        Lang lang = langMapper.mapToLang(langDto);
//
//        //Then
//        assertEquals(Numbers.ONE, lang.getId());
//        assertEquals(LangKind.EN, lang.getValue());
//    }
//
//    @Test
//    public void shouldMapToLangList() {
//        //Given
//        List<LangDto> langDtos = Arrays.asList(langDto);
//
//        //When
//        List<Lang> langs = langMapper.mapToLangList(langDtos);
//
//        //Then
//        assertEquals(1, langs.size());
//        assertEquals(Numbers.ONE, langs.get(0).getId());
//        assertEquals(LangKind.EN, langs.get(0).getValue());
//    }
//
//    @Test
//    public void shouldMapToLangDto() {
//        //When
//        LangDto langDto = langMapper.mapToLangDto(lang);
//
//        //Then
//        assertEquals(Numbers.ONE, langDto.getId());
//        assertEquals(LangKind.EN, langDto.getValue());
//    }
//
//    @Test
//    public void shouldMapToLangDtoList() {
//        //Given
//        List<Lang> langs = Arrays.asList(lang);
//
//        //When
//        List<LangDto> langDtos = langMapper.mapToLangDtoList(langs);
//
//        //Then
//        assertEquals(1, langDtos.size());
//        assertEquals(Numbers.ONE, langDtos.get(0).getId());
//        assertEquals(LangKind.EN, langDtos.get(0).getValue());
//    }
//
//    private HomeCollectionItem createHomeCollectionItem() {
//        Book book = new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");
//        HomeCollection homeCollection = new HomeCollection(1L, new User(), new ArrayList<>());
//        HomeCollectionItem homeCollectionItem = new HomeCollectionItem();
//        List<Form> forms = Arrays.asList(new Form(1L, BookKind.EBOOK, homeCollectionItem));
//        List<Lang> langs = Arrays.asList(new Lang(1L, LangKind.EN, homeCollectionItem));
//        MyScore myScore = new MyScore(1L, 5);
//
//        return new HomeCollectionItem(1L, book, homeCollection, myScore, forms, langs);
//    }
//
//    private HomeCollectionItemDto createHomeCollectionItemDto() {
//        BookDto bookDto = new BookDto(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");
//        HomeCollectionDto homeCollectionDto = new HomeCollectionDto(1L, new UserDto(), new ArrayList<>());
//        ScoreDto myScoreDto = new ScoreDto(1L, 5);
//        HomeCollectionItemDto homeCollectionItemDto =
//                new HomeCollectionItemDto(1L, bookDto, homeCollectionDto, myScoreDto, );
//        List<FormDto> formDtos = Arrays.asList(new FormDto(1L, BookKind.EBOOK, homeCollectionItemDto));
//        List<LangDto> langDtos = Arrays.asList(new LangDto(1L, LangKind.EN, homeCollectionItemDto));
//
//
//        return new HomeCollectionItemDto(1L, bookDto, homeCollectionDto, myScoreDto, formDtos, langDtos);
//    }
}
