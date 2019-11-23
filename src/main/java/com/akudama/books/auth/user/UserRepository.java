package com.akudama.books.auth.user;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
