package com.akudama.books.security;

import com.akudama.books.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    Optional<User> findById(long id);

    @Override
    User save(User user);

    @Override
    void delete(User user);

    void deleteById(long id);

    @Override
    long count();

    User findByEmail(String email);
}
