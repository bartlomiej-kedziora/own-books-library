package com.akudama.books.auth.user;

import com.akudama.books.auth.group.AuthGroupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class UserDto {

    private long id;
    private String username;
    private String password;
    private List<AuthGroupDto> authGroups;

    public UserDto(long id, String username, String password, List<AuthGroupDto> authGroups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authGroups = authGroups;
    }

    public static final class UserDtoBuilder {
        private long id;
        private String username;
        private String password;
        private List<AuthGroupDto> authGroups;

        public static UserDtoBuilder anUserDtoBuilder() {
            return new UserDtoBuilder();
        }

        private UserDtoBuilder() {
        }

        public UserDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDtoBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDtoBuilder withAuthGroups(List<AuthGroupDto> authGroups) {
            this.authGroups = authGroups;
            return this;
        }

        public UserDto builder() {
            return new UserDto(id, username, password, authGroups);
        }
    }
}
