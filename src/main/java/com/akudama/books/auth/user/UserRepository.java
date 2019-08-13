package com.akudama.books.auth.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    User findByUsername(String username);

    @Override
    User save(User user);

    @Override
    void delete(User user);

    void deleteById(long id);
}
