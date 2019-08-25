package com.akudama.books.repository;

import com.akudama.books.domain.entity.HomeCollection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface HomeCollectionRepository extends CrudRepository<HomeCollection, Long> {

    Optional<HomeCollection> findByUserId(long id);

    Optional<HomeCollection> findByUserUsername(String username);

    @Override
    HomeCollection save(HomeCollection homeCollection);

    @Override
    void delete(HomeCollection homeCollection);

    void deleteById(long id);

}
