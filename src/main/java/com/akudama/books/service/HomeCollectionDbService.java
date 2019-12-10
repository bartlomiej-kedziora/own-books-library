package com.akudama.books.service;

import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.repository.HomeCollectionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeCollectionDbService {

    private HomeCollectionRepository repository;

    @Autowired
    public HomeCollectionDbService(HomeCollectionRepository repository) {
        this.repository = repository;
    }

    public List<HomeCollection> getCollections() {
        return repository.findAll();
    }

    public Optional<HomeCollection> getCollection(final long id) {
        return repository.findByUserId(id);
    }

    public Optional<HomeCollection> getCollectionByUsername(final String username) {
        return repository.findByUserUsername(username);
    }

    public HomeCollection saveCollection(final HomeCollection homeCollection) {
        return repository.save(homeCollection);
    }

    public void deleteCollection(final long id) {
        repository.deleteById(id);
    }

}
