package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.ScoreDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.WorldScore;
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
@SpringBootTest
public class BookDetailsMapperTest {
    private Book book = createBook();

    @Autowired
    BookDetailsMapper bookDetailsMapper;

    @Test
    public void shouldMapToBook() {
        //Given
        BookDetailsDto bookDetailsDto = createBookDetailsDto();

        //When
        Book book = bookDetailsMapper.mapToBook(bookDetailsDto);

        //Then
        assertEquals(Numbers.ONE, book.getId());
        assertEquals(1976, book.getYear());
        assertEquals("Manitu", book.getTitle());
        assertEquals("Manitou", book.getTitleEng());
        assertEquals("Manitou", book.getSeries());
        assertEquals("horror", book.getGenre());
        assertEquals(1, book.getAuthors().size());
        assertEquals(Numbers.ONE, book.getAuthors().get(0).getId());
        assertEquals(1946, book.getAuthors().get(0).getYearOfBirth());
        assertEquals("Graham", book.getAuthors().get(0).getName());
        assertEquals("Masterton", book.getAuthors().get(0).getSurname());
        assertEquals("Edinburgh", book.getAuthors().get(0).getCity());
        assertEquals("Scotland", book.getAuthors().get(0).getCountry());
        assertEquals(Numbers.ONE, book.getWorldScore().getId());
        assertEquals(3, book.getWorldScore().getValue());
        assertEquals(Numbers.ZERO, book.getHomeCollectionItems().size());
    }

    @Test
    public void shouldMapToBookDetailsDto() {
        //When
        BookDetailsDto bookDetailsDto = bookDetailsMapper.mapToBookDetailsDto(book);

        //Then
        assertEquals(Numbers.ONE, bookDetailsDto.getId());
        assertEquals(1976, bookDetailsDto.getYear());
        assertEquals("Manitu", bookDetailsDto.getTitlePl());
        assertEquals("Manitou", bookDetailsDto.getTitleEn());
        assertEquals("Manitou", bookDetailsDto.getSeries());
        assertEquals("horror", bookDetailsDto.getGenre());
        assertEquals(1, bookDetailsDto.getAuthors().size());
        assertEquals(Numbers.ONE, bookDetailsDto.getAuthors().get(0).getId());
        assertEquals(1946, bookDetailsDto.getAuthors().get(0).getYearOfBirth());
        assertEquals("Graham", bookDetailsDto.getAuthors().get(0).getName());
        assertEquals("Masterton", bookDetailsDto.getAuthors().get(0).getSurname());
        assertEquals("Edinburgh", bookDetailsDto.getAuthors().get(0).getCity());
        assertEquals("Scotland", bookDetailsDto.getAuthors().get(0).getCountry());
        assertEquals(Numbers.ONE, bookDetailsDto.getWorldScore().getId());
        assertEquals(3, bookDetailsDto.getWorldScore().getValue());
        assertEquals(Numbers.ZERO, bookDetailsDto.getHomeCollectionItems().size());
    }

    @Test
    public void shouldMapToBookDetailsDtoList() {
        //Given
        List<Book> books = Arrays.asList(book);

        //When
        List<BookDetailsDto> bookDetailsDtos = bookDetailsMapper.mapToBookDetailsDtoList(books);

        //Then
        assertEquals(1, bookDetailsDtos.size());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getId());
        assertEquals(1976, bookDetailsDtos.get(0).getYear());
        assertEquals("Manitu", bookDetailsDtos.get(0).getTitlePl());
        assertEquals("Manitou", bookDetailsDtos.get(0).getTitleEn());
        assertEquals("Manitou", bookDetailsDtos.get(0).getSeries());
        assertEquals("horror", bookDetailsDtos.get(0).getGenre());
        assertEquals(1, bookDetailsDtos.get(0).getAuthors().size());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getAuthors().get(0).getId());
        assertEquals(1946, bookDetailsDtos.get(0).getAuthors().get(0).getYearOfBirth());
        assertEquals("Graham", bookDetailsDtos.get(0).getAuthors().get(0).getName());
        assertEquals("Masterton", bookDetailsDtos.get(0).getAuthors().get(0).getSurname());
        assertEquals("Edinburgh", bookDetailsDtos.get(0).getAuthors().get(0).getCity());
        assertEquals("Scotland", bookDetailsDtos.get(0).getAuthors().get(0).getCountry());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getWorldScore().getId());
        assertEquals(3, bookDetailsDtos.get(0).getWorldScore().getValue());
        assertEquals(Numbers.ZERO, bookDetailsDtos.get(0).getHomeCollectionItems().size());
    }

    private Book createBook() {
        List<Author> authors = Arrays.asList(new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland"));
        WorldScore worldScore = new WorldScore(1L, 3);

        return new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror", authors, worldScore, new ArrayList<>());
    }

    private BookDetailsDto createBookDetailsDto() {
        List<AuthorDto> authorDtos = Arrays.asList(AuthorDto.AuthorDtoBuilder.aAuthorDtoBuilder()
                .withId(1L)
                .withYearOfBirth(1946)
                .withName("Graham")
                .withSurname("Masterton")
                .withCity("Edinburgh")
                .withCountry("Scotland")
                .build());

        ScoreDto worldScoreDto = ScoreDto.ScoreDtoBuilder.aScoreDtoBuilder()
                .withId(1L)
                .withValue(3)
                .build();

        return BookDetailsDto.BookDetailsDtoBuilder.aBookDetailsDtoBuilder()
                .withId(1L)
                .withYear(1976)
                .withTitlePl("Manitu")
                .withTitleEn("Manitou")
                .withSeries("manitou")
                .withGenre("horror")
                .withAuthors(authorDtos)
                .withWorldScore(worldScoreDto)
                .withHomeCollectionItems(new ArrayList<>())
                .build();
    }
}
