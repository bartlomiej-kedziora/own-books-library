package com.akudama.books.auth.group;

import com.akudama.books.auth.user.UserDetailsDto;
import com.akudama.books.auth.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthGroupDetailsDto {

    private long id;
    private String username;
    private Role authGroup;
    private UserDetailsDto user;

    public static final class AuthGroupDetailsDtoBuilder {

        private long id;
        private String username;
        private Role authGroup;
        private UserDetailsDto user;

        private AuthGroupDetailsDtoBuilder() {
        }

        public static AuthGroupDetailsDtoBuilder anAuthGroupDetailsDtoBuilder() {
            return new AuthGroupDetailsDtoBuilder();
        }

        public AuthGroupDetailsDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public AuthGroupDetailsDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public AuthGroupDetailsDtoBuilder withAuthGroup(Role authGroup) {
            this.authGroup = authGroup;
            return this;
        }

        public AuthGroupDetailsDtoBuilder withUser(UserDetailsDto user) {
            this.user = user;
            return this;
        }

        public AuthGroupDetailsDto build() {
            return new AuthGroupDetailsDto(id, username, authGroup, user);
        }
    }
}
