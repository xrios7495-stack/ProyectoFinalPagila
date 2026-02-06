package com.example.demo.controller;

import com.example.demo.repository.FilmRepository;
import com.example.demo.entity.Film;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/films")
    public String films(
            @RequestParam(required = false) String title,
            Model model) {

        List<Film> films;

        if (title != null && !title.isEmpty()) {
            films = filmRepository.findByTitleContainingIgnoreCase(title);
        } else {
            films = filmRepository.findAll();
        }

        model.addAttribute("films", films);
        model.addAttribute("title", title);

        return "films";
    }
}
