package com.akudama.books.repository;

import com.akudama.books.domain.BookKind;
import com.akudama.books.domain.entity.Form;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FormRepository extends CrudRepository<Form, Long> {

    @Override
    Set<Form> findAll();

    Optional<Form> findById(long id);

    Optional<Form> findByValue(BookKind bookKind);

    @Override
    Form save(Form form);

    @Override
    void delete(Form form);

    void deleteById(long id);

    @Override
    long count();

}
