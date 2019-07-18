package com.akudama.books.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuthorDetailsDto {

    private AuthorDto authorDto;
    private List<BookDto> books;

    public AuthorDetailsDto(AuthorDto authorDto, List<BookDto> books) {
        this.authorDto = authorDto;
        this.books = books;
    }

    public static final class AuthorDetailsDtoBuilder {

        private AuthorDto authorDto;
        private List<BookDto> books;

        private AuthorDetailsDtoBuilder() {
        }

        public static AuthorDetailsDtoBuilder aAuthorDetailsDtoBuilder() {
            return new AuthorDetailsDtoBuilder();
        }

        public AuthorDetailsDtoBuilder withAuthorDto(AuthorDto authorDto) {
            this.authorDto = authorDto;
            return this;
        }

        public AuthorDetailsDtoBuilder withBooks(List<BookDto> books) {
            this.books = books;
            return this;
        }

        public AuthorDetailsDto build() {
            return new AuthorDetailsDto(authorDto, books);
        }
    }
}
