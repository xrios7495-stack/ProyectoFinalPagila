package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RentalRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;
    private final PaymentRepository paymentRepository;

    public DashboardController(CustomerRepository customerRepository,
                               RentalRepository rentalRepository,
                               PaymentRepository paymentRepository) {
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.paymentRepository = paymentRepository;
    }

    /**
     * Página principal
     * URL: http://localhost:8080/
     */
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalRentals", rentalRepository.count());
        model.addAttribute("totalPayments", paymentRepository.count());

        // 🔑 CLAVE
        model.addAttribute("title", "Dashboard");
        model.addAttribute("content", "dashboard");

        return "layout";
    }

    /**
     * Dashboard explícito
     * URL: http://localhost:8080/dashboard
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalRentals", rentalRepository.count());
        model.addAttribute("totalPayments", paymentRepository.count());

        // 🔑 CLAVE
        model.addAttribute("title", "Dashboard");
        model.addAttribute("content", "dashboard");

        return "layout";
    }
}
