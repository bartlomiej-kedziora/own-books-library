package com.akudama.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/books")
public class BookHtmlController {

    @GetMapping
    public String getBooksPage(Model model) {
        return "books";
    }
}
