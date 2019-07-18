package com.akudama.books.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookDto {
    private Long id;
    private int year;
    private String titlePl;
    private String titleEn;
    private String series;
    private String genre;

    public BookDto(Long id, int year, String titlePl, String titleEn, String series, String genre) {
        this.id = id;
        this.year = year;
        this.titlePl = titlePl;
        this.titleEn = titleEn;
        this.series = series;
        this.genre = genre;
    }

    public static final class BookDtoBuilder {
        private Long id;
        private int year;
        private String titlePl;
        private String titleEn;
        private String series;
        private String genre;

        private BookDtoBuilder() {
        }

        public static BookDtoBuilder aBookDtoBuilder() {
            return new BookDtoBuilder();
        }

        public BookDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BookDtoBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public BookDtoBuilder withTitlePl(String titlePl) {
            this.titlePl = titlePl;
            return this;
        }

        public BookDtoBuilder withTitleEn(String titleEn) {
            this.titleEn = titleEn;
            return this;
        }

        public BookDtoBuilder withSeries(String series) {
            this.series = series;
            return this;
        }

        public BookDtoBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookDto build() {
            return new BookDto(id, year, titlePl, titleEn, series, genre);
        }
    }
}
