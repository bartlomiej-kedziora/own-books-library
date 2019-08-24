package com.akudama.books.controller;

import com.akudama.books.service.HomeCollectionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/collections")
public class HomeCollectionController {

    private final HomeCollectionDbService service;

    @Autowired
    public HomeCollectionController(HomeCollectionDbService service) {
        this.service = service;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{collectionId}")
//    public HomeCollectionDto getCollection(@PathVariable long collectionId) {
//        return homeCollectionMapper.mapToHomeCollectionDto(
//                service.getCollection(collectionId).orElseThrow(ItemNotFoundException::new));
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{collectionId}")
//    public void deleteCollection(@PathVariable long collectionId) {
//        service.deleteCollection(collectionId);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public HomeCollectionDto updateCollection(@RequestBody HomeCollectionDto homeCollectionDto) {
//        return homeCollectionMapper.mapToHomeCollectionDto(
//                service.saveCollection(homeCollectionMapper.mapToHomeCollection(homeCollectionDto))
//        );
//    }
}
