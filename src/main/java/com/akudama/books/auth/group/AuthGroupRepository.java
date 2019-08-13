package com.akudama.books.auth.group;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AuthGroupRepository extends CrudRepository<AuthGroup, Long> {

    @Override
    List<AuthGroup> findAll();

    List<AuthGroup> findByUsername(String username);

    @Override
    AuthGroup save(AuthGroup authGroup);

    @Override
    void delete(AuthGroup authGroup);

    void deleteById(long id);
}
