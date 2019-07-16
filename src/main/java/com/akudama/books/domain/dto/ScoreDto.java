package com.akudama.books.domain.dto;

import lombok.Getter;

@Getter
public class ScoreDto {
    private final Long id;
    private final int value;

    private ScoreDto(Long id, int value) {
        this.id = id;
        this.value = value;
    }

    public static final class ScoreDtoBuilder {
        private Long id;
        private int value;

        private ScoreDtoBuilder() {
        }

        public ScoreDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ScoreDtoBuilder withValue(int value) {
            this.value = value;
            return this;
        }

        public ScoreDto build() {
            return new ScoreDto(id, value);
        }
    }

}
