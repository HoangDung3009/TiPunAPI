package com.example.tipunapi.repositories;

import com.example.tipunapi.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment getPaymentById(Long id);
}
