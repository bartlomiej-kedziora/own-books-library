package com.akudama.books.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static final class UserDtoBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;

        private UserDtoBuilder() {
        }

        public static UserDtoBuilder aUserDtoBuilder() {
            return new UserDtoBuilder();
        }

        public UserDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDto build() {
            return new UserDto(id, firstName, lastName, email);
        }
    }
}
