package com.example.ecommerce.controller;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String showPaymentForm() {
        return "payment";
    }

    @PostMapping
    public String processPayment(@ModelAttribute Payment payment) {
        paymentService.processPayment(payment);
        return "redirect:/payment/list";
    }

    @GetMapping("/list")
    public String listPayments(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payment-list";
    }
}
