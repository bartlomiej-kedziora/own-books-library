package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
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
public class AuthorDetailsMapperTest {
    private Book book = new Book(1L, 1975, "Manitu", "Manitou", "manitou", "horror");
    private Author author = new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland", Arrays.asList(book));

    @Autowired
    AuthorDetailsMapper authorDetailsMapper;

    @Test
    public void shouldMapToAuthor() {
        //Given
        BookDto bookDto = BookDto.BookDtoBuilder.aBookDtoBuilder()
                .withId(1L)
                .withYear(1975)
                .withTitlePl("Manitu")
                .withTitleEn("Manitou")
                .withSeries("manitou")
                .withGenre("horror")
                .build();
        AuthorDetailsDto authorDetailsDto = AuthorDetailsDto.AuthorDetailsDtoBuilder.aAuthorDetailsDtoBuilder()
                .withId(1L)
                .withYearOfBirth(1946)
                .withName("Graham")
                .withSurname("Masterton")
                .withCity("Edinburgh")
                .withCountry("Scotland")
                .withBooks(Arrays.asList(bookDto))
                .build();

        //When
        Author author = authorDetailsMapper.mapToAuthor(authorDetailsDto);

        //Then
        assertEquals(Numbers.ONE, author.getId());
        assertEquals(1946, author.getYearOfBirth());
        assertEquals("Graham", author.getName());
        assertEquals("Masterton", author.getSurname());
        assertEquals("Edinburgh", author.getCity());
        assertEquals("Scotland", author.getCountry());
        assertEquals(1, author.getBooks().size());
        assertEquals(Numbers.ONE, author.getBooks().get(0).getId());
        assertEquals(1975, author.getBooks().get(0).getYear());
        assertEquals("Manitu", author.getBooks().get(0).getTitle());
        assertEquals("Manitou", author.getBooks().get(0).getTitleEng());
        assertEquals("manitou", author.getBooks().get(0).getSeries());
        assertEquals("horror", author.getBooks().get(0).getGenre());
    }

    @Test
    public void shouldMapToAuthorDetailsDto() {
        //When
        AuthorDetailsDto authorDetailsDto = authorDetailsMapper.mapToAuthorDetailsDto(author);

        //Then
        assertEquals(Numbers.ONE, authorDetailsDto.getId());
        assertEquals(1946, authorDetailsDto.getYearOfBirth());
        assertEquals("Graham", authorDetailsDto.getName());
        assertEquals("Masterton", authorDetailsDto.getSurname());
        assertEquals("Edinburgh", authorDetailsDto.getCity());
        assertEquals("Scotland", authorDetailsDto.getCountry());
        assertEquals(1, authorDetailsDto.getBooks().size());
        assertEquals(Numbers.ONE, authorDetailsDto.getBooks().get(0).getId());
        assertEquals(1975, authorDetailsDto.getBooks().get(0).getYear());
        assertEquals("Manitu", authorDetailsDto.getBooks().get(0).getTitlePl());
        assertEquals("Manitou", authorDetailsDto.getBooks().get(0).getTitleEn());
        assertEquals("manitou", authorDetailsDto.getBooks().get(0).getSeries());
        assertEquals("horror", authorDetailsDto.getBooks().get(0).getGenre());
    }

    @Test
    public void shouldMapToAuthorDetailsDtoList() {
        //Given
        List<Author> authors = Arrays.asList(author);

        //When
        List<AuthorDetailsDto> authorDetailsDtos = authorDetailsMapper.mapToAuthorDetailsDtoList(authors);

        //Then
        assertEquals(1, authorDetailsDtos.size());
        assertEquals(Numbers.ONE, authorDetailsDtos.get(0).getId());
        assertEquals(1946, authorDetailsDtos.get(0).getYearOfBirth());
        assertEquals("Graham", authorDetailsDtos.get(0).getName());
        assertEquals("Masterton", authorDetailsDtos.get(0).getSurname());
        assertEquals("Edinburgh", authorDetailsDtos.get(0).getCity());
        assertEquals("Scotland", authorDetailsDtos.get(0).getCountry());
        assertEquals(1, authorDetailsDtos.get(0).getBooks().size());
        assertEquals(Numbers.ONE, authorDetailsDtos.get(0).getBooks().get(0).getId());
        assertEquals(1975, authorDetailsDtos.get(0).getBooks().get(0).getYear());
        assertEquals("Manitu", authorDetailsDtos.get(0).getBooks().get(0).getTitlePl());
        assertEquals("Manitou", authorDetailsDtos.get(0).getBooks().get(0).getTitleEn());
        assertEquals("manitou", authorDetailsDtos.get(0).getBooks().get(0).getSeries());
        assertEquals("horror", authorDetailsDtos.get(0).getBooks().get(0).getGenre());
    }
}
