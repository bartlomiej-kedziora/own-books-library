package com.akudama.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class FormHtmlController {

    @GetMapping("form")
    public String getCreateFormPage(Model model) {
        return "admin/form";
    }

    @GetMapping("forms")
    public String getFormsPage(Model model) {
        return "forms";
    }
}
