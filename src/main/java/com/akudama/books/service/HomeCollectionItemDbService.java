package com.akudama.books.service;

import static com.akudama.books.domain.entity.HomeCollectionItem.HomeCollectionItemBuilder.aHomeCollectionItem;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.controller.exceptions.ItemNotFoundWithMessageException;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.Form;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.domain.entity.Lang;
import com.akudama.books.repository.BookRepository;
import com.akudama.books.repository.FormRepository;
import com.akudama.books.repository.HomeCollectionItemRepository;
import com.akudama.books.repository.HomeCollectionRepository;
import com.akudama.books.repository.LangRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HomeCollectionItemDbService {

    private HomeCollectionItemRepository repository;
    private BookRepository bookRepository;
    private HomeCollectionRepository homeCollectionRepository;
    private FormRepository formRepository;
    private LangRepository langRepository;

    @Autowired
    public HomeCollectionItemDbService(HomeCollectionItemRepository repository,
            BookRepository bookRepository, HomeCollectionRepository homeCollectionRepository,
            FormRepository formRepository, LangRepository langRepository) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.homeCollectionRepository = homeCollectionRepository;
        this.formRepository = formRepository;
        this.langRepository = langRepository;
    }

    public Optional<List<HomeCollectionItem>> getItemCollectionByCollection(final long id) {
        return repository.findByHomeCollectionId(id);
    }

    public Optional<HomeCollectionItem> getItemCollectionByBook(final long id) {
        return repository.findByBookId(id);
    }

    public void deleteItemCollection(final long id) {
        repository.deleteById(id);
    }

    public HomeCollectionItem saveItemCollection(final HomeCollectionItem homeCollectionItem) {
        HomeCollection homeCollection = getHomeCollectionFromLoggedUser();
        Book bookFromHomeCollectionItem = homeCollectionItem.getBook();
        Book bookFromDb = bookRepository.findByTitleAndTitleEngAndSeriesAndGenreAndYear(
                bookFromHomeCollectionItem.getTitle(), bookFromHomeCollectionItem.getTitleEng(),
                bookFromHomeCollectionItem.getSeries(), bookFromHomeCollectionItem.getGenre(),
                bookFromHomeCollectionItem.getYear())
                .orElseGet(() -> bookRepository.save(homeCollectionItem.getBook()));
        SetIdToCurrentHomeCollectionItemIfExistsInDb(homeCollectionItem, bookFromDb);

        return repository.save(aHomeCollectionItem()
                .withId(homeCollectionItem.getId())
                .withBook(bookFromDb)
                .withHomeCollection(homeCollection)
                .withMyScore(homeCollectionItem.getMyScore())
                .withForms(findFormsWithId(homeCollectionItem.getForms()))
                .withLangs(findLangsWithId(homeCollectionItem.getLangs()))
                .build());
    }

    private void SetIdToCurrentHomeCollectionItemIfExistsInDb(HomeCollectionItem homeCollectionItem,
            Book book) {
        repository.findByBookId(book.getId())
                .ifPresent(collectionItem -> homeCollectionItem.setId(collectionItem.getId()));
    }

    private HomeCollection getHomeCollectionFromLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return homeCollectionRepository.findByUserUsername(username)
                .orElseThrow(ItemNotFoundException::new);
    }

    private Set<Form> findFormsWithId(Set<Form> forms) {
        return forms.stream()
                .map(this::getFormWithId)
                .collect(Collectors.toSet());
    }

    private Form getFormWithId(Form form) {
        return formRepository.findByValue(form.getValue())
                .orElseThrow(() -> new ItemNotFoundWithMessageException("Book's form not exists"));
    }

    private Set<Lang> findLangsWithId(Set<Lang> langs) {
        return langs.stream()
                .map(this::getLangWithId)
                .collect(Collectors.toSet());
    }

    private Lang getLangWithId(Lang lang) {
        return langRepository.findByValue(lang.getValue())
                .orElseThrow(() -> new ItemNotFoundWithMessageException("Book's language not exists"));
    }
}
