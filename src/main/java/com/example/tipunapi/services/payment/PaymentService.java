package com.example.tipunapi.services.payment;

import com.example.tipunapi.models.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
}
