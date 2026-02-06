package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private Integer paymentId;

    private Double amount;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    public Double getAmount() { return amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}
