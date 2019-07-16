package com.akudama.books.auth.group;

import com.akudama.books.auth.utils.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AuthGroupDto {

    private Role authGroup;

    public AuthGroupDto(Role authGroup) {
        this.authGroup = authGroup;
    }

    public static final class AuthGroupDtoBuilder {

        private Role authGroup;

        private AuthGroupDtoBuilder() {
        }

        public static AuthGroupDtoBuilder anAuthGroupDtoBuilder() {
            return new AuthGroupDtoBuilder();
        }

        public AuthGroupDtoBuilder withAuthGroup(Role authGroup) {
            this.authGroup = authGroup;
            return this;
        }

        public AuthGroupDto build() {
            return new AuthGroupDto(authGroup);
        }
    }
}
