package com.akudama.books.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

    protected Long id;
    protected int year;
    protected String title;
    protected String titleEng;
    protected String series;
    protected String genre;
}
