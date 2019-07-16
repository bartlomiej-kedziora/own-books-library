package com.akudama.books.auth.group;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.akudama.books.auth.group.AuthGroupDetailsDto.AuthGroupDetailsDtoBuilder.anAuthGroupDetailsDtoBuilder;
import static com.akudama.books.auth.group.AuthGroupDto.AuthGroupDtoBuilder.anAuthGroupDtoBuilder;

@Component
public class AuthGroupMapper {

    AuthGroup mapToAuthGroup(AuthGroupDetailsDto authGroupDetailsDto) {
        return new AuthGroup(
                authGroupDetailsDto.getId(),
                authGroupDetailsDto.getUsername(),
                authGroupDetailsDto.getAuthGroup()
        );
    }

    public List<AuthGroup> mapToAuthGroupList(List<AuthGroupDetailsDto> authGroupDtos) {
        return authGroupDtos.stream()
                .map(this::mapToAuthGroup)
                .collect(Collectors.toList());
    }

    AuthGroupDto mapToAuthGroupDto(AuthGroup authGroup) {
        return anAuthGroupDtoBuilder()
                .withAuthGroup(authGroup.getAuthGroup())
                .build();
    }

    public List<AuthGroupDto> mapToAuthGroupDtoList(List<AuthGroup> authGroups) {
        return authGroups.stream()
                .map(this::mapToAuthGroupDto)
                .collect(Collectors.toList());
    }

    public AuthGroupDetailsDto mapToAuthGroupDetailsDto(AuthGroup authGroup) {
        return anAuthGroupDetailsDtoBuilder()
                .withId(authGroup.getId())
                .withUsername(authGroup.getUsername())
                .withAuthGroup(authGroup.getAuthGroup())
                .build();
    }

    public List<AuthGroupDetailsDto> mapToAuthGroupDetailsDtoList(List<AuthGroup> authGroups) {
        return authGroups.stream()
                .map(this::mapToAuthGroupDetailsDto)
                .collect(Collectors.toList());
    }
}
