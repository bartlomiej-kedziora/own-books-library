package com.akudama.books.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BookDetailsDto {
    private final Long id;
    private final int year;
    private final String titlePl;
    private final String titleEn;
    private final String series;
    private final String genre;
    private final List<AuthorDto> authors;
    private final ScoreDto worldScore;
    private final List<HomeCollectionItemDto> homeCollectionItems;

    private BookDetailsDto(Long id,
                           int year,
                           String titlePl,
                           String titleEn,
                           String series,
                           String genre,
                           List<AuthorDto> authors,
                           ScoreDto worldScore,
                           List<HomeCollectionItemDto> homeCollectionItems) {
        this.id = id;
        this.year = year;
        this.titlePl = titlePl;
        this.titleEn = titleEn;
        this.series = series;
        this.genre = genre;
        this.authors = authors;
        this.worldScore = worldScore;
        this.homeCollectionItems = homeCollectionItems;
    }

    public static final class BookDetailsDtoBuilder {
        private Long id;
        private int year;
        private String titlePl;
        private String titleEn;
        private String series;
        private String genre;
        private List<AuthorDto> authors;
        private ScoreDto worldScore;
        private List<HomeCollectionItemDto> homeCollectionItems;

        private BookDetailsDtoBuilder() {
        }

        public static BookDetailsDtoBuilder aBookDetailsDtoBuilder() {
            return new BookDetailsDtoBuilder();
        }

        public BookDetailsDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BookDetailsDtoBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public BookDetailsDtoBuilder withTitlePl(String titlePl) {
            this.titlePl = titlePl;
            return this;
        }

        public BookDetailsDtoBuilder withTitleEn(String titleEn) {
            this.titleEn = titleEn;
            return this;
        }

        public BookDetailsDtoBuilder withSeries(String series) {
            this.series = series;
            return this;
        }

        public BookDetailsDtoBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookDetailsDtoBuilder withAuthors(List<AuthorDto> authors) {
            this.authors = authors;
            return this;
        }

        public BookDetailsDtoBuilder withWorldScore(ScoreDto worldScore) {
            this.worldScore = worldScore;
            return this;
        }

        public BookDetailsDtoBuilder withHomeCollectionItems(List<HomeCollectionItemDto> homeCollectionItems) {
            this.homeCollectionItems = homeCollectionItems;
            return this;
        }

        public BookDetailsDto build() {
            return new BookDetailsDto(id, year, titlePl, titleEn, series, genre, authors, worldScore, homeCollectionItems);
        }
    }
}
