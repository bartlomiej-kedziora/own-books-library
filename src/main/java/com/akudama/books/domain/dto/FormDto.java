package com.akudama.books.domain.dto;

import com.akudama.books.domain.BookKind;
import lombok.Getter;

@Getter
public class FormDto {
    private final Long id;
    private final BookKind value;
    private final HomeCollectionItemDto homeCollectionItem;

    private FormDto(Long id, BookKind value, HomeCollectionItemDto homeCollectionItem) {
        this.id = id;
        this.value = value;
        this.homeCollectionItem = homeCollectionItem;
    }

    public static final class FormDtoBuilder {
        private Long id;
        private BookKind value;
        private HomeCollectionItemDto homeCollectionItem;

        private FormDtoBuilder() {
        }

        public static FormDtoBuilder aFormDtoBuilder() {
            return new FormDtoBuilder();
        }

        public FormDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FormDtoBuilder withValue(BookKind value) {
            this.value = value;
            return this;
        }

        public FormDtoBuilder withHomeCollectionItem(HomeCollectionItemDto homeCollectionItem) {
            this.homeCollectionItem = homeCollectionItem;
            return this;
        }

        public FormDto build() {
            return new FormDto(id, value, homeCollectionItem);
        }
    }
}
