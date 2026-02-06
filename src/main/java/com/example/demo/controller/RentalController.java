package com.example.demo.controller;

import com.example.demo.repository.RentalRepository;
import com.example.demo.entity.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RentalController {

    private final RentalRepository rentalRepository;

    public RentalController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/rentals")
    public String rentals(
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end,
            @RequestParam(required = false) Integer storeId,
            Model model
    ) {

        if (start != null && end != null && storeId != null) {
            LocalDateTime startDate = LocalDateTime.parse(start);
            LocalDateTime endDate = LocalDateTime.parse(end);

            List<Rental> rentals = rentalRepository
                    .findRentalsByDateAndStore(startDate, endDate, storeId);

            model.addAttribute("rentals", rentals);
        }

        return "rentals";
    }
}

