package com.akudama.books.controller;

import com.akudama.books.controller.exceptions.ItemNotFoundException;
import com.akudama.books.domain.dto.HomeCollectionDto;
import com.akudama.books.mapper.ModelConverter;
import com.akudama.books.service.HomeCollectionDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public List<HomeCollectionDto> getCollections() {
        return modelConverter.convertToDtoList(service.getCollections(), HomeCollectionDto.class);
    }

    @GetMapping(value = "/{collectionId}")
    public HomeCollectionDto getCollection(@PathVariable long collectionId) {
        return modelConverter.convertToDto(
                service.getCollection(collectionId).orElseThrow(ItemNotFoundException::new), HomeCollectionDto.class);
    }

    @GetMapping(value = "/user")
    public HomeCollectionDto getCollectionByLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return modelConverter.convertToDto(
                service.getCollectionByUsername(authentication.getName())
                        .orElseThrow(ItemNotFoundException::new), HomeCollectionDto.class);
    }

    @DeleteMapping(value = "/{collectionId}")
    public void deleteCollection(@PathVariable long collectionId) {
        service.deleteCollection(collectionId);
    }
}
