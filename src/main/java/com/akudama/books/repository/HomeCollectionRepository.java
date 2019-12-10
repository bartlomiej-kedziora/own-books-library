package com.akudama.books.repository;

import com.akudama.books.domain.entity.HomeCollection;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface HomeCollectionRepository extends CrudRepository<HomeCollection, Long> {

    @Override
    List<HomeCollection> findAll();

    Optional<HomeCollection> findByUserId(long id);

    Optional<HomeCollection> findByUserUsername(String username);

    @Override
    HomeCollection save(HomeCollection homeCollection);

    @Override
    void delete(HomeCollection homeCollection);

    void deleteById(long id);

}
