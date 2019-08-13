package com.akudama.books.auth.user;

import com.akudama.books.auth.group.AuthGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.akudama.books.auth.user.UserDto.UserDtoBuilder.anUserDtoBuilder;

@Component
public class UserMapper {

    private AuthGroupMapper authGroupMapper;

    @Autowired
    public UserMapper(AuthGroupMapper authGroupMapper) {
        this.authGroupMapper = authGroupMapper;
    }

    public User mapToUser(final UserDetailsDto userDetailsDto) {
        return new User(
                userDetailsDto.getId(),
                userDetailsDto.getUsername(),
                userDetailsDto.getPassword(),
                authGroupMapper.mapToAuthGroupList(userDetailsDto.getAuthGroups())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return anUserDtoBuilder()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .withAuthGroups(authGroupMapper.mapToAuthGroupDtoList(user.getAuthGroups()))
                .builder();
    }

    List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    public UserDetailsDto mapToUserDetailsDto(final User user) {
        return UserDetailsDto.UserDetailsDtoBuilder.anUserDetailsDtoBuilder()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .withAuthGroups(authGroupMapper.mapToAuthGroupDetailsDtoList(user.getAuthGroups()))
                .builder();
    }

    List<UserDetailsDto> mapToUserDetailsDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDetailsDto)
                .collect(Collectors.toList());
    }
}
