package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.entity.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    public CustomerController(CustomerRepository customerRepository,
                              RentalRepository rentalRepository) {
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String customerDetail(@PathVariable Integer id, Model model) {
        List<Rental> rentals = rentalRepository.findByCustomerId(id);
        model.addAttribute("rentals", rentals);
        return "list";
    }
}

