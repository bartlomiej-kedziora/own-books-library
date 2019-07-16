package com.akudama.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("page-not-found")
public class PageNotFoundController {

    @GetMapping
    public String getPageNotFound(Model model) {
        return "page-not-found";
    }
}
