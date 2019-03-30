package com.akudama.books.mapper;

import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.dto.LangDto;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.Lang;
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
public class LangMapperTest {
    private LangDto langDto = new LangDto(1L, LangKind.EN, new HomeCollectionDto());
    private Lang lang = new Lang(1L, LangKind.EN, new HomeCollection());

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
}
