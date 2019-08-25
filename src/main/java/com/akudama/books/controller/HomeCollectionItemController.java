package com.akudama.books.controller;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.dto.HomeCollectionItemDto;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.domain.entity.HomeCollectionItem;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.HomeCollectionDbService;
import com.akudama.books.service.HomeCollectionItemDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/items-collection")
public class HomeCollectionItemController {

    private final HomeCollectionItemDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public HomeCollectionItemController(HomeCollectionItemDbService service, ModelConverter modelConverter) {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{collectionId}")
    public HomeCollectionItemDto getCollectionByCollection(@PathVariable long collectionId) {
        return modelConverter.convertToDto(
                service.getItemCollectionByCollection(collectionId).orElseThrow(ItemNotFoundException::new), HomeCollectionItemDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/book")
    public HomeCollectionItemDto getCollectionByBook(@PathVariable long bookId) {
        return modelConverter.convertToDto(
                service.getItemCollectionByBook(bookId).orElseThrow(ItemNotFoundException::new), HomeCollectionItemDto.class);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{itemCollectionId}")
    public void deleteCollection(@PathVariable long itemCollectionId) {
        service.deleteItemCollection(itemCollectionId);
    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public HomeCollectionDto updateCollection(@RequestBody HomeCollectionDto homeCollectionDto) {
//        return homeCollectionMapper.mapToHomeCollectionDto(
//                service.saveCollection(homeCollectionMapper.mapToHomeCollection(homeCollectionDto))
//        );
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBookWithDetails(@RequestBody HomeCollectionItemDto itemCollection) {
        service.saveItemCollection(
                modelConverter.convertToEntity(itemCollection, HomeCollectionItem.class));
    }
}
