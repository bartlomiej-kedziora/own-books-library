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
        assertEquals("Manitu", book.getTitlePl());
        assertEquals("Manitou", book.getTitleEn());
        assertEquals("Manitou", book.getSeries());
        assertEquals("horror", book.getGenre());
        assertEquals(1, book.getAuthors().size());
        assertEquals(Numbers.ONE, book.getAuthors().get(0).getId());
        assertEquals(1946, book.getAuthors().get(0).getYearOfBirth());
        assertEquals("Graham", book.getAuthors().get(0).getName());
        assertEquals("Masterton", book.getAuthors().get(0).getSurname());
        assertEquals("Edinburgh", book.getAuthors().get(0).getCity());
        assertEquals("Scotland", book.getAuthors().get(0).getCountry());
        assertEquals(Numbers.ONE, book.getMyScore().getId());
        assertEquals(5, book.getMyScore().getValue());
        assertEquals(Numbers.ONE, book.getWorldScore().getId());
        assertEquals(3, book.getWorldScore().getValue());
        assertEquals(Numbers.ONE, book.getHomeCollection().getId());
        assertEquals(1, book.getHomeCollection().getForms().size());
        assertEquals(Numbers.ONE, book.getHomeCollection().getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, book.getHomeCollection().getForms().get(0).getValue());
        assertEquals(1, book.getHomeCollection().getLangs().size());
        assertEquals(Numbers.ONE, book.getHomeCollection().getLangs().get(0).getId());
        assertEquals(LangKind.EN, book.getHomeCollection().getLangs().get(0).getValue());
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
        assertEquals(Numbers.ONE, bookDetailsDto.getMyScore().getId());
        assertEquals(5, bookDetailsDto.getMyScore().getValue());
        assertEquals(Numbers.ONE, bookDetailsDto.getWorldScore().getId());
        assertEquals(3, bookDetailsDto.getWorldScore().getValue());
        assertEquals(Numbers.ONE, bookDetailsDto.getHomeCollection().getId());
        assertEquals(1, bookDetailsDto.getHomeCollection().getForms().size());
        assertEquals(Numbers.ONE, bookDetailsDto.getHomeCollection().getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, bookDetailsDto.getHomeCollection().getForms().get(0).getValue());
        assertEquals(1, bookDetailsDto.getHomeCollection().getLangs().size());
        assertEquals(Numbers.ONE, bookDetailsDto.getHomeCollection().getLangs().get(0).getId());
        assertEquals(LangKind.EN, bookDetailsDto.getHomeCollection().getLangs().get(0).getValue());
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
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getMyScore().getId());
        assertEquals(5, bookDetailsDtos.get(0).getMyScore().getValue());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getWorldScore().getId());
        assertEquals(3, bookDetailsDtos.get(0).getWorldScore().getValue());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getHomeCollection().getId());
        assertEquals(1, bookDetailsDtos.get(0).getHomeCollection().getForms().size());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getHomeCollection().getForms().get(0).getId());
        assertEquals(BookKind.EBOOK, bookDetailsDtos.get(0).getHomeCollection().getForms().get(0).getValue());
        assertEquals(1, bookDetailsDtos.get(0).getHomeCollection().getLangs().size());
        assertEquals(Numbers.ONE, bookDetailsDtos.get(0).getHomeCollection().getLangs().get(0).getId());
        assertEquals(LangKind.EN, bookDetailsDtos.get(0).getHomeCollection().getLangs().get(0).getValue());
    }

    private Book createBook() {
        List<Author> authors = Arrays.asList(new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland"));
        HomeCollection homeCollection = new HomeCollection();
        List<Form> forms = Arrays.asList(new Form(1L, BookKind.EBOOK, homeCollection));
        List<Lang> langs = Arrays.asList(new Lang(1L, LangKind.EN, homeCollection));
        homeCollection = new HomeCollection(1L, forms, langs);
        MyScore myScore = new MyScore(1L, 5);
        WorldScore worldScore = new WorldScore(1L, 3);

        return new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror", authors, myScore, worldScore, homeCollection);
    }

    private BookDetailsDto createBookDetailsDto() {
        List<AuthorDto> authorDtos = Arrays.asList(new AuthorDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland"));
        HomeCollectionDto homeCollectionDto = new HomeCollectionDto();
        List<FormDto> formDtos = Arrays.asList(new FormDto(1L, BookKind.EBOOK, homeCollectionDto));
        List<LangDto> langDtos = Arrays.asList(new LangDto(1L, LangKind.EN, homeCollectionDto));
        homeCollectionDto = new HomeCollectionDto(1L, formDtos, langDtos);
        ScoreDto myScoreDto = new ScoreDto(1L, 5);
        ScoreDto worldScoreDto = new ScoreDto(1L, 3);

        return new BookDetailsDto(1L, 1976, "Manitu", "Manitou", "Manitou", "horror", authorDtos, myScoreDto, worldScoreDto, homeCollectionDto);
    }
}
