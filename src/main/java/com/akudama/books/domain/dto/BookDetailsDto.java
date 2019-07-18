package com.akudama.books.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookDetailsDto {

    private BookDto bookDto;
    private List<AuthorDto> authors;
    private ScoreDto worldScore;

    public BookDetailsDto(BookDto bookDto,
            List<AuthorDto> authors,
            ScoreDto worldScore) {
        this.bookDto = bookDto;
        this.authors = authors;
        this.worldScore = worldScore;
    }

    public static final class BookDetailsDtoBuilder {

        private BookDto bookDto;
        private List<AuthorDto> authors;
        private ScoreDto worldScore;

        private BookDetailsDtoBuilder() {
        }

        public static BookDetailsDtoBuilder aBookDetailsDtoBuilder() {
            return new BookDetailsDtoBuilder();
        }

        public BookDetailsDtoBuilder withBookDto(BookDto bookDto) {
            this.bookDto = bookDto;
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

        public BookDetailsDto build() {
            return new BookDetailsDto(bookDto, authors, worldScore);
        }
    }
}
