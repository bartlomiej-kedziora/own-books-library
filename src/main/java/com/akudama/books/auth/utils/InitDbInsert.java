package com.akudama.books.auth.utils;

import com.akudama.books.auth.group.AuthGroup;
import com.akudama.books.auth.user.User;
import com.akudama.books.auth.user.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitDbInsert {

    private static final Role ROLE = Role.ROLE_ADMIN;

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    private UserRepository repository;

    @Autowired
    public InitDbInsert(UserRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void createDefaultAdmin() {

        User admin = repository.findByUsername(username);

        if (isNull(admin)) {
            admin = createUserWithGroup();
        }

        repository.save(admin);
    }

    private boolean isNull(User user) {
        return user == null;
    }

    private User createUserWithGroup() {
        List<AuthGroup> authGroupList = new ArrayList<>();
        User user = new User(username, password, authGroupList);
        AuthGroup authGroup = new AuthGroup(username, ROLE, user);
        user.getAuthGroups().add(authGroup);

        return user;
    }
}
