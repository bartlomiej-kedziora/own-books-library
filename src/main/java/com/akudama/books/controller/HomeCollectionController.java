package com.akudama.books.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.HomeCollectionDetailsDto;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.domain.entity.HomeCollection;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.HomeCollectionDbService;
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
@RequestMapping("/v1/collections")
public class HomeCollectionController {

    private final HomeCollectionDbService service;
    private final ModelConverter modelConverter;

    @Autowired
    public HomeCollectionController(HomeCollectionDbService service, ModelConverter modelConverter) {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{collectionId}")
    public HomeCollectionDto getCollection(@PathVariable long collectionId) {
        return modelConverter.convertToDto(
                service.getCollection(collectionId).orElseThrow(ItemNotFoundException::new), HomeCollectionDto.class);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public HomeCollectionDto getCollectionByUser(Authentication authentication) {
        return modelConverter.convertToDto(
                service.getCollectionByUsername(authentication.getName())
                        .orElseThrow(ItemNotFoundException::new), HomeCollectionDto.class);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{collectionId}")
    public void deleteCollection(@PathVariable long collectionId) {
        service.deleteCollection(collectionId);
    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public HomeCollectionDetailsDto updateCollection(@RequestBody HomeCollectionDetailsDto homeCollectionDto) {
//        return homeCollectionMapper.mapToHomeCollectionDto(
//                service.saveCollection(homeCollectionMapper.mapToHomeCollection(homeCollectionDto))
//        );
//    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public void createBookWithDetails(@RequestBody HomeCollectionDetailsDto collection) {
        service.saveCollection(
                modelConverter.convertToEntity(collection, HomeCollection.class));
    }
}
