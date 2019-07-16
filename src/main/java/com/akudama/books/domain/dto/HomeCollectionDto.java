package com.akudama.books.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class HomeCollectionDto {
    private final Long id;
    private final UserDto user;
    private final List<HomeCollectionItemDto> homeCollectionItems;

    private HomeCollectionDto(Long id, UserDto user, List<HomeCollectionItemDto> homeCollectionItems) {
        this.id = id;
        this.user = user;
        this.homeCollectionItems = homeCollectionItems;
    }

    public static final class HomeCollectionDtoBuilder {
        private Long id;
        private UserDto user;
        private List<HomeCollectionItemDto> homeCollectionItems;

        private HomeCollectionDtoBuilder() {
        }

        public static HomeCollectionDtoBuilder aHomeCollectionDtoBuilder() {
            return new HomeCollectionDtoBuilder();
        }

        public HomeCollectionDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public HomeCollectionDtoBuilder withUser(UserDto user) {
            this.user = user;
            return this;
        }

        public HomeCollectionDtoBuilder withHomeCollectionItems(List<HomeCollectionItemDto> homeCollectionItems) {
            this.homeCollectionItems = homeCollectionItems;
            return this;
        }

        public HomeCollectionDto build() {
            return new HomeCollectionDto(id, user, homeCollectionItems);
        }
    }
}
