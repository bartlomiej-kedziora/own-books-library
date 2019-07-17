package com.akudama.books.service;

import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.repository.HomeCollectionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeCollectionDbService {
    @Autowired
    private HomeCollectionRepository repository;

    public Optional<HomeCollection> getCollection(final long id) {
        return repository.findByUserId(id);
    }

}
