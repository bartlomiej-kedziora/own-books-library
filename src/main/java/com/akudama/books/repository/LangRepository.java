package com.akudama.books.repository;

import com.akudama.books.domain.entity.Lang;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface LangRepository extends CrudRepository<Lang, Long> {

    @Override
    List<Lang> findAll();

    Optional<Lang> findById(long id);

    @Override
    Lang save(Lang lang);

    @Override
    void delete(Lang lang);

    void deleteById(long id);

    @Override
    long count();

}
