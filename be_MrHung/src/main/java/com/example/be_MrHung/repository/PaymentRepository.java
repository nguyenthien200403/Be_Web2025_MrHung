package com.example.be_MrHung.repository;

import com.example.be_MrHung.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByBookingBookingId(Integer bookingId);

    List<Payment> findByPaymentStatus(Payment.PaymentStatus status);

    List<Payment> findByPaymentMethod(Payment.PaymentMethod method);

    Payment findByTransactionId(String transactionId);

    boolean existsByTransactionId(String transactionId);
}