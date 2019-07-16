package com.akudama.books.service;

import com.akudama.books.domain.entity.Lang;
import com.akudama.books.repository.LangRepository;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LangDbService {

    private LangRepository repository;

    @Autowired
    public LangDbService(LangRepository repository) {
        this.repository = repository;
    }

    public Set<Lang> getAllLangs() {
        return repository.findAll();
    }

    public Optional<Lang> getLang(final long id) {
        return repository.findById(id);
    }

    public Lang saveLang(final Lang lang) {
        return repository.save(lang);
    }

    public void deleteLang(final long id) {
        repository.deleteById(id);
    }

}
