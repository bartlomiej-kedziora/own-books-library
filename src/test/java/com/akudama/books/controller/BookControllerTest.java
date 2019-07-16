package com.akudama.books.controller;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.dto.*;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.mapper.BookDetailsMapper;
import com.akudama.books.mapper.BookMapper;
import com.akudama.books.service.BookDbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    private Book book = new Book(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");
    private BookDto bookDto = new BookDto(1L, 1976, "Manitu", "Manitou", "Manitou", "horror");
    private BookDetailsDto bookDetailsDto = createBookDetailsDto();

    private List<Book> books = Arrays.asList(book);
    private List<BookDto> bookDtos = Arrays.asList(bookDto);

    private Optional<Book> optionalBook = Optional.of(book);

    private long id = 1;
    private Gson gson = new Gson();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private BookDbService service;

    @MockBean
    private BookDetailsMapper bookDetailsMapper;

    @Test
    public void shouldGetBooks() throws Exception {
        //Given
        when(service.getAllBooks()).thenReturn(books);
        when(bookMapper.mapToBookDtoList(ArgumentMatchers.anyList())).thenReturn(bookDtos);

        //When & Then
        mockMvc.perform(get("/v1/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].year", is(1976)))
                .andExpect(jsonPath("$[0].titlePl", is("Manitu")))
                .andExpect(jsonPath("$[0].titleEn", is("Manitou")))
                .andExpect(jsonPath("$[0].series", is("Manitou")))
                .andExpect(jsonPath("$[0].genre", is("horror")));
    }

    @Test
    public void shouldGetBook() throws Exception {
        //Given
        when(service.getBook(id)).thenReturn(optionalBook);
        when(bookMapper.mapToBookDto(ArgumentMatchers.any(Book.class))).thenReturn(bookDto);

        //When & Then
        mockMvc.perform(get("/v1/books/{bookId}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.year", is(1976)))
                .andExpect(jsonPath("$.titlePl", is("Manitu")))
                .andExpect(jsonPath("$.titleEn", is("Manitou")))
                .andExpect(jsonPath("$.series", is("Manitou")))
                .andExpect(jsonPath("$.genre", is("horror")));
    }

    @Test
    public void shouldGetBookWithDetails() throws Exception {
        //Given
        when(service.getBook(id)).thenReturn(optionalBook);
        when(bookDetailsMapper.mapToBookDetailsDto(ArgumentMatchers.any(Book.class))).thenReturn(bookDetailsDto);

        //When & Then
        mockMvc.perform(get("/v1/books/{bookId}/details", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.year", is(1976)))
                .andExpect(jsonPath("$.titlePl", is("Manitu")))
                .andExpect(jsonPath("$.titleEn", is("Manitou")))
                .andExpect(jsonPath("$.series", is("Manitou")))
                .andExpect(jsonPath("$.genre", is("horror")))
                .andExpect(jsonPath("$.authors[0].id", is(1)))
                .andExpect(jsonPath("$.authors[0].name", is("Graham")))
                .andExpect(jsonPath("$.authors[0].surname", is("Masterton")))
                .andExpect(jsonPath("$.myScore.id", is(1)))
                .andExpect(jsonPath("$.myScore.value", is(5)))
                .andExpect(jsonPath("$.worldScore.id", is(1)))
                .andExpect(jsonPath("$.worldScore.value", is(3)))
                .andExpect(jsonPath("$.homeCollection.id", is(1)))
                .andExpect(jsonPath("$.homeCollection.forms[0].id", is(1)))
                .andExpect(jsonPath("$.homeCollection.forms[0].value", is("EBOOK")))
                .andExpect(jsonPath("$.homeCollection.langs[0].id", is(1)))
                .andExpect(jsonPath("$.homeCollection.langs[0].value", is("EN")));
    }

    @Test
    public void shouldDeleteBook() throws Exception {
        //When
        mockMvc.perform(delete("/v1/books/{bookId}", id))
                .andExpect(status().isOk());

        //Then
        verify(service, times(1)).deleteBook(id);

    }

    @Test
    public void shouldUpdateBook() throws Exception {
        //Given
        when(bookDetailsMapper.mapToBook(ArgumentMatchers.any(BookDetailsDto.class))).thenReturn(book);
        when(service.saveBook(ArgumentMatchers.any(Book.class))).thenReturn(book);
        when(bookDetailsMapper.mapToBookDetailsDto(ArgumentMatchers.any(Book.class))).thenReturn(bookDetailsDto);

        String jsonContent = gson.toJson(bookDto);

        //When & Then
        mockMvc.perform(put("/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.year", is(1976)))
                .andExpect(jsonPath("$.titlePl", is("Manitu")))
                .andExpect(jsonPath("$.titleEn", is("Manitou")))
                .andExpect(jsonPath("$.series", is("Manitou")))
                .andExpect(jsonPath("$.genre", is("horror")))
                .andExpect(jsonPath("$.authors[0].id", is(1)))
                .andExpect(jsonPath("$.authors[0].name", is("Graham")))
                .andExpect(jsonPath("$.authors[0].surname", is("Masterton")))
                .andExpect(jsonPath("$.myScore.id", is(1)))
                .andExpect(jsonPath("$.myScore.value", is(5)))
                .andExpect(jsonPath("$.worldScore.id", is(1)))
                .andExpect(jsonPath("$.worldScore.value", is(3)))
                .andExpect(jsonPath("$.homeCollection.id", is(1)))
                .andExpect(jsonPath("$.homeCollection.forms[0].id", is(1)))
                .andExpect(jsonPath("$.homeCollection.forms[0].value", is("EBOOK")))
                .andExpect(jsonPath("$.homeCollection.langs[0].id", is(1)))
                .andExpect(jsonPath("$.homeCollection.langs[0].value", is("EN")));
    }

    @Captor
    ArgumentCaptor<BookDetailsDto> captor;
    @Test
    public void shouldCreateBook() throws Exception {
        //Given
        BookDetailsDto bookDetailsDto = new BookDetailsDto(
                1L,
                1976,
                "Manitu",
                "Manitou",
                "Manitou",
                "horror",
                new ArrayList<>(),
                null,
                null);

        when(bookDetailsMapper.mapToBook(ArgumentMatchers.any(BookDetailsDto.class))).thenReturn(book);
        when(service.saveBook(ArgumentMatchers.any(Book.class))).thenReturn(book);

        String jsonContent = gson.toJson(bookDto);

        //When
        mockMvc.perform(post("/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is2xxSuccessful());

        //Then
        verify(bookDetailsMapper, times(1)).mapToBook(captor.capture());
        BookDetailsDto result = captor.getValue();
        assertThat(result).isEqualToComparingFieldByField(bookDetailsDto);
    }

    private BookDetailsDto createBookDetailsDto() {
        List<AuthorDto> authorDtos = Arrays.asList(new AuthorDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland"));
        ScoreDto worldScoreDto = new ScoreDto(1L, 3);

        return new BookDetailsDto(1L, 1976, "Manitu", "Manitou", "Manitou", "horror", authorDtos, worldScoreDto, new ArrayList<>());
    }
}
