package com.akudama.books.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HomeCollectionItemDto {

    private Long id;
    private BookDetailsDto book;
    private ScoreDto myScore;
    private List<FormDto> forms;
    private List<LangDto> langs;

    public HomeCollectionItemDto(Long id, BookDetailsDto book, ScoreDto myScore,
            List<FormDto> forms, List<LangDto> langs) {
        this.id = id;
        this.book = book;
        this.myScore = myScore;
        this.forms = forms;
        this.langs = langs;
    }

    public static final class HomeCollectionItemDtoBuilder {

        private Long id;
        private BookDetailsDto book;
        private ScoreDto myScore;
        private List<FormDto> forms;
        private List<LangDto> langs;

        private HomeCollectionItemDtoBuilder() {
        }

        public static HomeCollectionItemDtoBuilder aHomeCollectionItemDtoBuilder() {
            return new HomeCollectionItemDtoBuilder();
        }

        public HomeCollectionItemDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public HomeCollectionItemDtoBuilder withBook(BookDetailsDto book) {
            this.book = book;
            return this;
        }

        public HomeCollectionItemDtoBuilder withMyScore(ScoreDto myScore) {
            this.myScore = myScore;
            return this;
        }

        public HomeCollectionItemDtoBuilder withForms(List<FormDto> forms) {
            this.forms = forms;
            return this;
        }

        public HomeCollectionItemDtoBuilder withLangs(List<LangDto> langs) {
            this.langs = langs;
            return this;
        }

        public HomeCollectionItemDto build() {
            return new HomeCollectionItemDto(id, book, myScore, forms, langs);
        }
    }
}
