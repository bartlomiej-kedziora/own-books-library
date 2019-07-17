package com.akudama.books.repository;

import com.akudama.books.domain.entity.HomeCollection;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface HomeCollectionRepository extends CrudRepository<HomeCollection, Long> {

    Optional<HomeCollection> findByUserId(long id);

}
