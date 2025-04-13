package com.example.be_MrHung.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "payment_id")
    private Booking booking;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod method;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private PaymentStatus status = PaymentStatus.PENDING;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_time")
    private Date paymentTime;

    @Column(name = "card_last_four", length = 4)
    private String cardLastFour;

    @Column(name = "bank_code", length = 50)
    private String bankCode;

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.status = paymentStatus;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public enum PaymentMethod {
        CREDIT_CARD, BANK_TRANSFER, E_WALLET, CASH
    }

    public enum PaymentStatus {
        PENDING, PAID, CANCELLED, FAILED, REFUNDED
    }
}