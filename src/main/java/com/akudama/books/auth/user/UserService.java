package com.akudama.books.auth.user;

import com.akudama.books.auth.group.AuthGroup;
import com.akudama.books.auth.group.AuthGroupRepository;
import com.akudama.books.auth.utils.BcryptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        List<AuthGroup> authGroups = authGroupRepository.findByUsername(username);
        return new UserPrincipal(user, authGroups);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getByName(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(final User user) {
        user.setPassword(new BcryptGenerator(user.getPassword()).encrypt());
        System.out.println(user.getPassword());
        user.getAuthGroups().get(0).setUsername(user.getUsername());
        user.getAuthGroups().get(0).setUser(user);
        return userRepository.save(user);
    }
}
