package com.akudama.books.auth.user;

import com.akudama.books.auth.group.AuthGroupDetailsDto;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDetailsDto {

    private long id;
    private String username;
    private String password;
    private List<AuthGroupDetailsDto> authGroups;

    public UserDetailsDto(long id, String username, String password, List<AuthGroupDetailsDto> authGroups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authGroups = authGroups;
    }

    public static final class UserDetailsDtoBuilder {

        private long id;
        private String username;
        private String password;
        private List<AuthGroupDetailsDto> authGroups;

        public static UserDetailsDtoBuilder anUserDetailsDtoBuilder() {
            return new UserDetailsDtoBuilder();
        }

        private UserDetailsDtoBuilder() {
        }

        public UserDetailsDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UserDetailsDtoBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDetailsDtoBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDetailsDtoBuilder withAuthGroups(List<AuthGroupDetailsDto> authGroups) {
            this.authGroups = authGroups;
            return this;
        }

        public UserDetailsDto builder() {
            return new UserDetailsDto(id, username, password, authGroups);
        }
    }
}
