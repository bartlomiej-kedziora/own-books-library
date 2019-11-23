package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.auth.user.User;
import com.akudama.books.auth.user.UserService;
import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.HomeCollectionItemDetailsDto;
import com.akudama.books.domain.entity.Book;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.BookDbService;
import com.akudama.books.service.HomeCollectionDbService;
import com.akudama.books.service.HomeCollectionItemDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/items-collection")
public class HomeCollectionItemController {

    private final HomeCollectionItemDbService service;
    private final BookDbService bookDbService;
    private final HomeCollectionDbService homeCollectionDbService;
    private final UserService userService;
    private final ModelConverter modelConverter;

    @Autowired
    public HomeCollectionItemController(HomeCollectionItemDbService service, BookDbService bookDbService,
            HomeCollectionDbService homeCollectionDbService, UserService userService, ModelConverter modelConverter) {
        this.service = service;
        this.bookDbService = bookDbService;
        this.homeCollectionDbService = homeCollectionDbService;
        this.userService = userService;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{collectionId}")
    public HomeCollectionItemDetailsDto getCollectionByCollection(@PathVariable long collectionId) {
        return modelConverter.convertToDto(
                service.getItemCollectionByCollection(collectionId).orElseThrow(ItemNotFoundException::new),
                HomeCollectionItemDetailsDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/book")
    public HomeCollectionItemDetailsDto getCollectionByBook(@PathVariable long bookId) {
        return modelConverter.convertToDto(
                service.getItemCollectionByBook(bookId).orElseThrow(ItemNotFoundException::new),
                HomeCollectionItemDetailsDto.class);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{itemCollectionId}")
    public void deleteCollection(@PathVariable long itemCollectionId) {
        service.deleteItemCollection(itemCollectionId);
    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public HomeCollectionDetailsDto updateCollection(@RequestBody HomeCollectionDetailsDto homeCollectionDto) {
//        return homeCollectionMapper.mapToHomeCollectionDto(
//                service.saveCollection(homeCollectionMapper.mapToHomeCollection(homeCollectionDto))
//        );
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBookWithDetails(@RequestBody HomeCollectionItemDetailsDto itemCollection) {
        service.saveItemCollection(
                modelConverter.convertToEntity(itemCollection, HomeCollectionItem.class));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book", consumes = APPLICATION_JSON_VALUE)
    public void createHomeCollectionItemByBookId(@RequestBody Book bookId, Authentication authentication) {
        Book book = bookDbService.getBook(bookId.getId()).orElseThrow(ItemNotFoundException::new);
        String username = authentication.getName();
        User user = userService.getByName(username);
        HomeCollection newHomeCollection = new HomeCollection();
        newHomeCollection.setUser(user);
        HomeCollection homeCollection = homeCollectionDbService.getCollectionByUsername(username)
                .orElseGet(() -> homeCollectionDbService.saveCollection(newHomeCollection));
        HomeCollectionItem itemCollection = new HomeCollectionItem();
        itemCollection.setBook(book);
        itemCollection.setHomeCollection(homeCollection);

        service.saveItemCollection(itemCollection);
    }
}
