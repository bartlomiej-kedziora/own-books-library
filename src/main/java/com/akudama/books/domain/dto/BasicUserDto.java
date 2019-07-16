package com.akudama.books.domain.dto;

import com.akudama.books.auth.group.AuthGroupDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BasicUserDto {

    private long id;
    private String username;
    private List<AuthGroupDto> authGroups;
}
