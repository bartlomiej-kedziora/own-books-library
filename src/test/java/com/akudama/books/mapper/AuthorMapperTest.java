package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.entity.Author;
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
public class AuthorMapperTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void shouldMapToAuthor() {
        //Given
        AuthorDto authorDto = AuthorDto.AuthorDtoBuilder.aAuthorDtoBuilder()
                .withId(1L)
                .withYearOfBirth(1946)
                .withName("Graham")
                .withSurname("Masterton")
                .withCity("Edinburgh")
                .withCountry("Scotland")
                .build();

        //When
        Author author = authorMapper.mapToAuthor(authorDto);

        //Then
        assertEquals(Numbers.ONE, author.getId());
        assertEquals(1946, author.getYearOfBirth());
        assertEquals("Graham", author.getName());
        assertEquals("Masterton", author.getSurname());
        assertEquals("Edinburgh", author.getCity());
        assertEquals("Scotland", author.getCountry());
    }

    @Test
    public void shouldMapToAuthorDto() {
        //Given
        Author author = new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland");

        //When
        AuthorDto authorDto = authorMapper.mapToAuthorDto(author);

        //Then
        assertEquals(Numbers.ONE, authorDto.getId());
        assertEquals(1946, authorDto.getYearOfBirth());
        assertEquals("Graham", authorDto.getName());
        assertEquals("Masterton", authorDto.getSurname());
        assertEquals("Edinburgh", authorDto.getCity());
        assertEquals("Scotland", authorDto.getCountry());
    }

    @Test
    public void shouldMapToAuthorDtoList() {
        //Given
        List<Author> authors = Arrays.asList(new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland"));

        //When
        List<AuthorDto> authorDtos = authorMapper.mapToAuthorDtoList(authors);

        //Then
        assertEquals(1, authorDtos.size());
        assertEquals(Numbers.ONE, authorDtos.get(0).getId());
        assertEquals(1946, authorDtos.get(0).getYearOfBirth());
        assertEquals("Graham", authorDtos.get(0).getName());
        assertEquals("Masterton", authorDtos.get(0).getSurname());
        assertEquals("Edinburgh", authorDtos.get(0).getCity());
        assertEquals("Scotland", authorDtos.get(0).getCountry());
    }
}
