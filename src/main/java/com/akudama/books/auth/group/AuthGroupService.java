package com.akudama.books.auth.group;

import com.akudama.books.auth.user.User;
import com.akudama.books.auth.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthGroupService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    @Autowired
    public AuthGroupService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
