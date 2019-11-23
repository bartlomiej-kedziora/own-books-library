package com.akudama.books.repository;

import com.akudama.books.domain.entity.HomeCollectionItem;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface HomeCollectionItemRepository extends CrudRepository<HomeCollectionItem, Long> {

    Optional<HomeCollectionItem> findByBookId(long id);

    Optional<HomeCollectionItem> findByHomeCollectionId(long id);

    @Override
    HomeCollectionItem save(HomeCollectionItem homeCollectionItem);

    @Override
    void delete(HomeCollectionItem homeCollectionItem);

    void deleteById(long id);

}
