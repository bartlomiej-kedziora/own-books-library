package com.akudama.books.repository;

import com.akudama.books.domain.LangKind;
import com.akudama.books.domain.entity.Lang;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface LangRepository extends CrudRepository<Lang, Long> {

    @Override
    Set<Lang> findAll();

    Optional<Lang> findById(long id);

    Optional<Lang> findByValue(LangKind langKind);

    @Override
    Lang save(Lang lang);

    @Override
    void delete(Lang lang);

    void deleteById(long id);

    @Override
    long count();
}
