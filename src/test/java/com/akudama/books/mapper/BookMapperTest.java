package com.akudama.books.mapper;

import com.akudama.books.domain.Numbers;
import com.akudama.books.domain.dto.BookDto;
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
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void shouldMapToBook() {
        //Given
        BookDto bookDto = BookDto.BookDtoBuilder.aBookDtoBuilder()
                .withId(1L)
                .withYear(1976)
                .withTitlePl("Manitu")
                .withTitleEn("Manitou")
                .withSeries("manitou")
                .withGenre("horror")
                .build();

        //When
        Book book = bookMapper.mapToBook(bookDto);

        //Then
        assertEquals(Numbers.ONE, book.getId());
        assertEquals(1976, book.getYear());
        assertEquals("Manitu", book.getTitlePl());
        assertEquals("Manitou", book.getTitleEn());
        assertEquals("Manitou", book.getSeries());
        assertEquals("horror", book.getGenre());
    }

    @Test
    public void shouldMapToBookDto() {
        //Given
        Book book = new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");

        //When
        BookDto bookDto = bookMapper.mapToBookDto(book);

        //Then
        assertEquals(Numbers.ONE, bookDto.getId());
        assertEquals(1976, bookDto.getYear());
        assertEquals("Manitu", bookDto.getTitlePl());
        assertEquals("Manitou", bookDto.getTitleEn());
        assertEquals("Manitou", bookDto.getSeries());
        assertEquals("horror", bookDto.getGenre());
    }

    @Test
    public void shouldMapToBookDtoList() {
        //Given
        List<Book> books = Arrays.asList(new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror"));

        //When
        List<BookDto> bookDtos = bookMapper.mapToBookDtoList(books);

        //Then
        assertEquals(1, bookDtos.size());
        assertEquals(Numbers.ONE, bookDtos.get(0).getId());
        assertEquals(1976, bookDtos.get(0).getYear());
        assertEquals("Manitu", bookDtos.get(0).getTitlePl());
        assertEquals("Manitou", bookDtos.get(0).getTitleEn());
        assertEquals("Manitou", bookDtos.get(0).getSeries());
        assertEquals("horror", bookDtos.get(0).getGenre());
    }
}
