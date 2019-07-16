package com.akudama.books.mapper;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.FormDto;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
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
public class FormMapperTest {
    private FormDto formDto = new FormDto(1L, BookKind.EBOOK, new HomeCollectionItemDto());
    private Form form = new Form(1L, BookKind.EBOOK, new HomeCollectionItem());

    @Autowired
    private FormMapper formMapper;

    @Test
    public void shouldMapToForm() {
        //When
        Form form = formMapper.mapToForm(formDto);

        //Then
        assertEquals(Numbers.ONE, form.getId());
        assertEquals(BookKind.EBOOK, form.getValue());
    }

    @Test
    public void shouldMapToFormList() {
        //Given
        List<FormDto> formDtos = Arrays.asList(formDto);

        //When
        List<Form> forms = formMapper.mapToFormList(formDtos);

        //Then
        assertEquals(1, forms.size());
        assertEquals(Numbers.ONE, forms.get(0).getId());
        assertEquals(BookKind.EBOOK, forms.get(0).getValue());
    }

    @Test
    public void shouldMapToFormDto() {
        //When
        FormDto formDto = formMapper.mapToFormDto(form);

        //Then
        assertEquals(Numbers.ONE, formDto.getId());
        assertEquals(BookKind.EBOOK, formDto.getValue());
    }

    @Test
    public void shouldMapToFormDtoList() {
        //Given
        List<Form> forms = Arrays.asList(form);

        //When
        List<FormDto> formDtos = formMapper.mapToFormDtoList(forms);

        //Then
        assertEquals(1, formDtos.size());
        assertEquals(Numbers.ONE, formDtos.get(0).getId());
        assertEquals(BookKind.EBOOK, formDtos.get(0).getValue());
    }
}
