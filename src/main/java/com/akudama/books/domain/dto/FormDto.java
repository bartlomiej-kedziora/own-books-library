package com.akudama.books.domain.dto;

import com.akudama.books.domain.BookKind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormDto {

    private Long id;
    private BookKind value;

    public static final class FormDtoBuilder {

        private Long id;
        private BookKind value;

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

        public FormDto build() {
            return new FormDto(id, value);
        }
    }
}
