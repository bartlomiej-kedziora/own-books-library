package com.akudama.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/authors")
public class AuthorHtmlController {

    @GetMapping
    public String getAuthorPage(Model model) {
        return "authors";
    }
}
