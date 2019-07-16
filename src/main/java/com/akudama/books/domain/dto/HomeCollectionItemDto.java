package com.akudama.books.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class HomeCollectionItemDto {
    private final Long id;
    private final BookDto book;
    private final HomeCollectionDto homeCollection;
    private final ScoreDto myScore;
    private final List<FormDto> forms;
    private final List<LangDto> langs;

    private HomeCollectionItemDto(Long id, BookDto book, HomeCollectionDto homeCollection, ScoreDto myScore, List<FormDto> forms, List<LangDto> langs) {
        this.id = id;
        this.book = book;
        this.myScore = myScore;
        this.forms = forms;
        this.langs = langs;
        this.homeCollection = homeCollection;
    }

    public static final class HomeCollectionItemDtoBuilder {
        private Long id;
        private BookDto book;
        private HomeCollectionDto homeCollection;
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

        public HomeCollectionItemDtoBuilder withBook(BookDto book) {
            this.book = book;
            return this;
        }

        public HomeCollectionItemDtoBuilder withHomeCollection(HomeCollectionDto homeCollection) {
            this.homeCollection = homeCollection;
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
            return new HomeCollectionItemDto(id, book, homeCollection, myScore, forms, langs);
        }
    }
}
