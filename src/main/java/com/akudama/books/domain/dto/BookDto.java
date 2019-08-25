package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    protected Long id;
    protected int year;
    protected String title;
    protected String titleEng;
    protected String series;
    protected String genre;
}
