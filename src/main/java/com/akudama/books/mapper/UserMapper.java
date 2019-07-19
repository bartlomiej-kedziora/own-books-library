package com.akudama.books.mapper;

import static com.akudama.books.domain.dto.UserDto.UserDtoBuilder.aUserDtoBuilder;

import com.akudama.books.domain.dto.UserDto;
import com.akudama.books.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return aUserDtoBuilder()
                .withId(user.getId())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .build();
    }
}
