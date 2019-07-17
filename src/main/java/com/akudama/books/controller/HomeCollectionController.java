package com.akudama.books.controller;

import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.mapper.HomeCollectionMapper;
import com.akudama.books.service.HomeCollectionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/collections")
public class HomeCollectionController {

    private final HomeCollectionDbService service;
    private final HomeCollectionMapper homeCollectionMapper;

    @Autowired
    public HomeCollectionController(HomeCollectionDbService service,
            HomeCollectionMapper homeCollectionMapper) {
        this.service = service;
        this.homeCollectionMapper = homeCollectionMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{collectionId}")
    public HomeCollectionDto getCollection(@PathVariable long collectionId) {
        return homeCollectionMapper.mapToHomeCollectionDto(
                service.getCollection(collectionId).orElseThrow(ItemNotFoundException::new));
    }
}
