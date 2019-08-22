package com.akudama.books.controller;

import com.akudama.books.auth.user.User;
import com.akudama.books.auth.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = {"/books", "/books/{id}"})
public class BookHtmlController {

    @Autowired
    UserService service;

    @GetMapping
    public String getBooksPage(Model model, Authentication authentication) {
        User user = service.getByName(authentication.getName());
        model.addAttribute("user", user);

        return "books";
    }
}
