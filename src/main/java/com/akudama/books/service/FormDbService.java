package com.akudama.books.service;

import com.akudama.books.domain.entity.Form;
import com.akudama.books.repository.FormRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormDbService {
    private FormRepository repository;

    @Autowired
    public FormDbService(FormRepository repository) {
        this.repository = repository;
    }

    public List<Form> getAllForms() {
        return repository.findAll();
    }

    public Optional<Form> getForm(final long id) {
        return repository.findById(id);
    }

    public Form saveForm(final Form form) {
        return repository.save(form);
    }

    public void deleteForm(final long id) {
        repository.deleteById(id);
    }
}
