package com.example.demo.controller;

import com.example.demo.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {

    private final PaymentRepository paymentRepository;

    public ReportController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/reports")
    public String reports(Model model) {

        List<Object[]> income = paymentRepository.getMonthlyIncome();
        model.addAttribute("income", income);

        return "reports";
    }
}
