package com.akudama.books.auth.user;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.service.HomeCollectionDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final HomeCollectionDbService homeCollectionDbService;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper,
            HomeCollectionDbService homeCollectionDbService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.homeCollectionDbService = homeCollectionDbService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDetailsDto user) {
        User userWithGeneratedId = userService.saveUser(userMapper.mapToUser(user));
        homeCollectionDbService.saveCollection(new HomeCollection(userWithGeneratedId));
    }
}
