package com.akudama.books.service;

import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.repository.HomeCollectionItemRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeCollectionItemDbService {

    private HomeCollectionItemRepository repository;

    @Autowired
    public HomeCollectionItemDbService(HomeCollectionItemRepository repository) {
        this.repository = repository;
    }

    public Optional<HomeCollectionItem> getItemCollectionByCollection(final long id) {
        return repository.findByHomeCollectionId(id);
    }

    public Optional<HomeCollectionItem> getItemCollectionByBook(final long id) {
        return repository.findByBookId(id);
    }

    public HomeCollectionItem saveItemCollection(final HomeCollectionItem homeCollectionItem) {
        return repository.save(homeCollectionItem);
    }

    public void deleteItemCollection(final long id) {
        repository.deleteById(id);
    }

}
