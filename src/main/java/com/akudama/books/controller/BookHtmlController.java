package com.akudama.books.controller;

import com.akudama.books.service.HomeCollectionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class BookHtmlController {

    @Autowired
    HomeCollectionDbService collectionDbService;

    @GetMapping(value = {"book"})
    public String getCreateBooksPage(Model model) {
        return "admin/book";
    }

    @GetMapping(value = {"books", "books/{id}"})
    public String getBooksPage(Model model) {//}, Authentication authentication) {
//        HomeCollection collection = collectionDbService
//                .getCollectionByUsername(authentication.getName()).get();
////                .orElseThrow(ItemNotFoundException::new);
//        if (collection != null) {
//            model.addAttribute("collection", collection);
//        }

        return "books";
    }
}
