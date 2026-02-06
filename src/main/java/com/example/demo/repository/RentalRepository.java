package com.example.demo.repository;

import com.example.demo.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findByCustomerId(Integer customerId);

    @Query(value = """
        SELECT r.*
        FROM rental r
        JOIN inventory i ON r.inventory_id = i.inventory_id
        WHERE r.rental_date BETWEEN :start AND :end
          AND i.store_id = :storeId
        ORDER BY r.rental_date
        """, nativeQuery = true)
    List<Rental> findRentalsByDateAndStore(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end,
            @Param("storeId") Integer storeId
    );
}
