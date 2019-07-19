package com.akudama.books.domain.dto;

import com.akudama.books.domain.LangKind;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LangDto {

    private Long id;
    private LangKind value;
    ;

    public LangDto(Long id, LangKind value) {
        this.id = id;
        this.value = value;
    }

    public static final class LangDtoBuilder {

        private Long id;
        private LangKind value;

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

        public LangDto build() {
            return new LangDto(id, value);
        }
    }
}
