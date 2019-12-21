package com.akudama.books.repository;

import com.akudama.books.domain.entity.Author;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Override
    List<Author> findAll();

    Optional<Author> findById(long id);

    Optional<List<Author>> findByBooksId(long id);

    Optional<Author> findByNameAndSurnameAndYearOfBirthAndCountryAndCity(String name, String surname, int yearOfBirth,
            String Country, String City);

    @Override
    Author save(Author author);

    @Override
    void delete(Author author);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
