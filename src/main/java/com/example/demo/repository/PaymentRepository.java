package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = """
        SELECT
            TO_CHAR(payment_date, 'YYYY-MM') AS month,
            SUM(amount) AS total
        FROM payment
        GROUP BY month
        ORDER BY month
        """, nativeQuery = true)
    List<Object[]> getMonthlyIncome();
}
