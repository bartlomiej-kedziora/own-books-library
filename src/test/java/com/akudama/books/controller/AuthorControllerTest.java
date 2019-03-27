package com.akudama.books.controller;

import com.akudama.books.domain.dto.AuthorDetailsDto;
import com.akudama.books.domain.dto.AuthorDto;
import com.akudama.books.domain.entity.Author;
import com.akudama.books.mapper.AuthorDetailsMapper;
import com.akudama.books.mapper.AuthorMapper;
import com.akudama.books.service.AuthorDbService;
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
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    private Author author = new Author(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland");
    private AuthorDto authorDto = new AuthorDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland");
    private Gson gson = new Gson();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorMapper authorMapper;

    @MockBean
    private AuthorDbService service;

    @MockBean
    private AuthorDetailsMapper authorDetailsMapper;

    @Test
    public void shouldGetAuthors() throws Exception {
        //Given
        List<AuthorDto> authorDtos = new ArrayList<>();
        authorDtos.add(authorDto);

        List<Author> authors = new ArrayList<>();
        authors.add(author);

        when(service.getAllAuthors()).thenReturn(authors);
        when(authorMapper.mapToAuthorDtoList(ArgumentMatchers.anyList())).thenReturn(authorDtos);

        //When & Then
        mockMvc.perform(get("/v1/authors").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].yearOfBirth", is(1946)))
                .andExpect(jsonPath("$[0].name", is("Graham")))
                .andExpect(jsonPath("$[0].surname", is("Masterton")))
                .andExpect(jsonPath("$[0].city", is("Edinburgh")))
                .andExpect(jsonPath("$[0].country", is("Scotland")));
    }

    @Test
    public void shouldGetAuthor() throws Exception {
        //Given
        Optional<Author> optionalAuthor = Optional.of(author);

        when(service.getAuthor(1)).thenReturn(optionalAuthor);
        when(authorMapper.mapToAuthorDto(ArgumentMatchers.any(Author.class))).thenReturn(authorDto);

        //When & Then
        mockMvc.perform(get("/v1/authors/{authorId}", 1L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.yearOfBirth", is(1946)))
                .andExpect(jsonPath("$.name", is("Graham")))
                .andExpect(jsonPath("$.surname", is("Masterton")))
                .andExpect(jsonPath("$.city", is("Edinburgh")))
                .andExpect(jsonPath("$.country", is("Scotland")));
    }

    @Test
    public void shouldGetAuthorWithDetails() throws Exception {
        //Given
        List<AuthorDetailsDto.BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(new AuthorDetailsDto.BookDto(1L, "Manitu", "Manitou"));
        AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland", bookDtos);

        Optional<Author> optionalAuthor = Optional.of(author);

        when(service.getAuthor(1)).thenReturn(optionalAuthor);
        when(authorDetailsMapper.mapToAuthorDetailsDto(ArgumentMatchers.any(Author.class))).thenReturn(authorDetailsDto);

        //When & Then
        mockMvc.perform(get("/v1/authors/{authorId}/details", 1L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.yearOfBirth", is(1946)))
                .andExpect(jsonPath("$.name", is("Graham")))
                .andExpect(jsonPath("$.surname", is("Masterton")))
                .andExpect(jsonPath("$.city", is("Edinburgh")))
                .andExpect(jsonPath("$.country", is("Scotland")))
                .andExpect(jsonPath("$.books", hasSize(1)))
                .andExpect(jsonPath("$.books[0].id", is(1)))
                .andExpect(jsonPath("$.books[0].titlePl", is("Manitu")))
                .andExpect(jsonPath("$.books[0].titleEn", is("Manitou")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        long authorId = 1;

        //When
        mockMvc.perform(delete("/v1/authors/{authorId}", authorId))
                .andExpect(status().isOk());

        //Then
        verify(service, times(1)).deleteAuthor(authorId);
    }

    @Test
    public void shouldUpdateAuthor() throws Exception {
        //Given
        List<AuthorDetailsDto.BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(new AuthorDetailsDto.BookDto(1L, "Manitu", "Manitou"));
        AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland", bookDtos);

        when(authorDetailsMapper.mapToAuthor(ArgumentMatchers.any(AuthorDetailsDto.class))).thenReturn(author);
        when(service.saveAuthor(ArgumentMatchers.any(Author.class))).thenReturn(author);
        when(authorDetailsMapper.mapToAuthorDetailsDto(ArgumentMatchers.any(Author.class))).thenReturn(authorDetailsDto);

        String jsonContent = gson.toJson(authorDto);

        //When & Then
        mockMvc.perform(put("/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.yearOfBirth", is(1946)))
                .andExpect(jsonPath("$.name", is("Graham")))
                .andExpect(jsonPath("$.surname", is("Masterton")))
                .andExpect(jsonPath("$.city", is("Edinburgh")))
                .andExpect(jsonPath("$.country", is("Scotland")))
                .andExpect(jsonPath("$.books", hasSize(1)))
                .andExpect(jsonPath("$.books[0].id", is(1)))
                .andExpect(jsonPath("$.books[0].titlePl", is("Manitu")))
                .andExpect(jsonPath("$.books[0].titleEn", is("Manitou")));
    }

    @Captor
    ArgumentCaptor<AuthorDetailsDto> captor;
    @Test
    public void shouldCreateAuthor() throws Exception {
        //Given
        AuthorDetailsDto authorDetailsDto = new AuthorDetailsDto(1L, 1946, "Graham", "Masterton", "Edinburgh", "Scotland", new ArrayList<>());

        when(authorDetailsMapper.mapToAuthor(ArgumentMatchers.any(AuthorDetailsDto.class))).thenReturn(author);
        when(service.saveAuthor(ArgumentMatchers.any(Author.class))).thenReturn(author);

        String jsonContent = gson.toJson(authorDto);

        //When
        mockMvc.perform(post("/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is2xxSuccessful());

        //Then
        verify(authorDetailsMapper, times(1)).mapToAuthor(captor.capture());
        AuthorDetailsDto result = captor.getValue();
        assertThat(result).isEqualToComparingFieldByField(authorDetailsDto);
    }

}
