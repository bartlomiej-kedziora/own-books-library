package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.auth.user.UserService;
import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.HomeCollectionItemDetailsDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.BookDbService;
import com.akudama.books.service.HomeCollectionDbService;
import com.akudama.books.service.HomeCollectionItemDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<HomeCollectionItemDetailsDto> getCollectionByCollection(@PathVariable long collectionId) {
        return modelConverter.convertToDtoList(
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
    public void createBookWithDetails(@RequestBody HomeCollectionItemDto itemCollection) {
        HomeCollectionItemDetailsDto homeCollectionItemDetailsDto = modelConverter.convertToDto(
                itemCollection, HomeCollectionItemDetailsDto.class
        );

        service.saveItemCollection(
                modelConverter.convertToEntity(homeCollectionItemDetailsDto, HomeCollectionItem.class));
    }
}
