package com.example.tipunapi.controllers;

import com.example.tipunapi.models.Payment;
import com.example.tipunapi.services.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @GetMapping("")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }
}
