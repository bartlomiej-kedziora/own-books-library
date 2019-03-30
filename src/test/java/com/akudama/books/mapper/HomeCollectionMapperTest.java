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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeCollectionMapperTest {

    @Autowired
    private HomeCollectionMapper homeCollectionMapper;

    @Test
    public void shouldMapToHomeCollection() {
        //Given
        HomeCollectionDto homeCollectionDto = createHomeCollectionDto();

        //When
        HomeCollection homeCollection = homeCollectionMapper.mapToHomeCollection(homeCollectionDto);

        //Then
        assertEquals(Numbers.ONE, homeCollection.getId());
        assertEquals(Numbers.ONE, homeCollection.getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollection.getForms().get(0).getValue());
        assertEquals(Numbers.ONE, homeCollection.getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollection.getLangs().get(0).getValue());
    }

    @Test
    public void shouldMapToHomeCollectionDto() {
        //Given
        HomeCollection homeCollection = createHomeCollection();

        //When
        HomeCollectionDto homeCollectionDto = homeCollectionMapper.mapToHomeCollectionDto(homeCollection);

        //Then
        assertEquals(Numbers.ONE, homeCollectionDto.getId());
        assertEquals(1, homeCollectionDto.getForms().size());
        assertEquals(Numbers.ONE, homeCollectionDto.getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollectionDto.getForms().get(0).getValue());
        assertEquals(1, homeCollectionDto.getLangs().size());
        assertEquals(Numbers.ONE, homeCollectionDto.getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollectionDto.getLangs().get(0).getValue());
    }

    @Test
    public void shouldMapToHomeCollectionDtoList() {
        //Given
        List<HomeCollection> homeCollections = Arrays.asList(createHomeCollection());

        //When
        List<HomeCollectionDto> homeCollectionDtos = homeCollectionMapper.mapToHomeCollectionDtoList(homeCollections);

        //Then
        assertEquals(1, homeCollectionDtos.size());
        assertEquals(Numbers.ONE, homeCollectionDtos.get(0).getId());
        assertEquals(1, homeCollectionDtos.get(0).getForms().size());
        assertEquals(Numbers.ONE, homeCollectionDtos.get(0).getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, homeCollectionDtos.get(0).getForms().get(0).getValue());
        assertEquals(1, homeCollectionDtos.get(0).getLangs().size());
        assertEquals(Numbers.ONE, homeCollectionDtos.get(0).getLangs().get(0).getId());
        assertEquals(LangKind.EN, homeCollectionDtos.get(0).getLangs().get(0).getValue());
    }

    private HomeCollection createHomeCollection() {

        HomeCollection homeCollection = new HomeCollection();
        List<Form> forms = Arrays.asList(new Form(1L, BookKind.EBOOK, homeCollection));
        List<Lang> langs = Arrays.asList(new Lang(1L, LangKind.EN, homeCollection));

        return new HomeCollection(1L, forms, langs);
    }

    private HomeCollectionDto createHomeCollectionDto() {
        HomeCollectionDto homeCollectionDto = new HomeCollectionDto();
        List<FormDto> formDtos = Arrays.asList(new FormDto(1L, BookKind.EBOOK, homeCollectionDto));
        List<LangDto> langDtos = Arrays.asList(new LangDto(1L, LangKind.EN, homeCollectionDto));

        return new HomeCollectionDto(1L, formDtos, langDtos);
    }
}
