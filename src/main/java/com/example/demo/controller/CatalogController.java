package com.example.demo.controller;

import com.example.demo.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    private final FilmRepository filmRepository;

    public CatalogController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/catalog")
    public String catalog(
            @RequestParam(required = false) String search,
            Model model) {

        if (search != null && !search.isBlank()) {
            model.addAttribute("films",
                    filmRepository.findByTitleContainingIgnoreCase(search));
        } else {
            model.addAttribute("films", filmRepository.findAll());
        }

        model.addAttribute("title", "Catálogo");
        model.addAttribute("content", "catalog");
        return "layout";
    }
}
