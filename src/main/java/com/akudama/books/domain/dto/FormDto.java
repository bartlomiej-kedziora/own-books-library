package com.akudama.books.domain.dto;

import com.akudama.books.domain.BookKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class FormDto {
    private final Long id;
    private final BookKind value;

    private FormDto(Long id, BookKind value) {
        this.id = id;
        this.value = value;
    }

    public static final class FormDtoBuilder {
        private Long id;
        private BookKind value;

        private FormDtoBuilder() {}

        public FormDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FormDtoBuilder withValue(BookKind value) {
            this.value = value;
            return this;
        }

        public FormDto build() {
            return new FormDto(id, value);
        }
    }
}
