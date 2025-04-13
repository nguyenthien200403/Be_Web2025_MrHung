package com.example.be_MrHung.services;

import com.example.be_MrHung.models.Payment;
import com.example.be_MrHung.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PaymentService {

    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        // Logic xử lý thanh toán
        payment.setPaymentStatus(Payment.PaymentStatus.PAID);
        payment.setPaymentTime(new Date());
        logger.info("Processing payment for booking ID: " + payment.getBooking().getBookingId());
        return paymentRepository.save(payment);
    }

    public Payment getPaymentByBookingId(Integer bookingId) {
        Payment payment = paymentRepository.findByBookingBookingId(bookingId);
        if (payment == null) {
            logger.warning("No payment found for booking ID: " + bookingId);
        }
        return payment;
    }

    public Payment updatePaymentStatus(Integer paymentId, Payment.PaymentStatus status) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setPaymentStatus(status);
            logger.info("Updated payment status for ID: " + paymentId + " to " + status);
            return paymentRepository.save(payment);
        } else {
            logger.warning("Payment not found for ID: " + paymentId);
            return null;
        }
    }
}