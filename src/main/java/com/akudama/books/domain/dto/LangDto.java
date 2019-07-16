package com.akudama.books.domain.dto;

import com.akudama.books.domain.LangKind;
import lombok.Getter;

@Getter
public class LangDto {
    private final Long id;
    private final LangKind value;
    private final HomeCollectionItemDto homeCollectionItem;

    private LangDto(Long id, LangKind value, HomeCollectionItemDto homeCollectionItem) {
        this.id = id;
        this.value = value;
        this.homeCollectionItem = homeCollectionItem;
    }

    public static final class LangDtoBuilder {
        private Long id;
        private LangKind value;
        private HomeCollectionItemDto homeCollectionItem;

        private LangDtoBuilder() {
        }

        public static LangDtoBuilder alangDtoBuilder() {
            return new LangDtoBuilder();
        }

        public LangDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public LangDtoBuilder withValue(LangKind value) {
            this.value = value;
            return this;
        }

        public LangDtoBuilder withHomeCollectionItem(HomeCollectionItemDto homeCollectionItemDto) {
            this.homeCollectionItem = homeCollectionItemDto;
            return this;
        }

        public LangDto build() {
            return new LangDto(id, value, homeCollectionItem);
        }
    }
}
