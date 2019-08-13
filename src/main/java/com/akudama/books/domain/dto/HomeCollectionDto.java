package com.akudama.books.domain.dto;

import java.util.List;

import com.akudama.books.auth.user.UserDetailsDto;
import com.akudama.books.auth.user.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HomeCollectionDto {

    private Long id;
    private UserDetailsDto user;
    private List<HomeCollectionItemDto> homeCollectionItems;

    public HomeCollectionDto(Long id, UserDetailsDto user,
            List<HomeCollectionItemDto> homeCollectionItems) {
        this.id = id;
        this.user = user;
        this.homeCollectionItems = homeCollectionItems;
    }

    public static final class HomeCollectionDtoBuilder {

        private Long id;
        private UserDetailsDto user;
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

        public HomeCollectionDtoBuilder withUser(UserDetailsDto user) {
            this.user = user;
            return this;
        }

        public HomeCollectionDtoBuilder withHomeCollectionItems(
                List<HomeCollectionItemDto> homeCollectionItems) {
            this.homeCollectionItems = homeCollectionItems;
            return this;
        }

        public HomeCollectionDto build() {
            return new HomeCollectionDto(id, user, homeCollectionItems);
        }
    }
}
