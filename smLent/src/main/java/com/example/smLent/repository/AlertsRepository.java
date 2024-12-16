package com.example.smLent.repository;

import com.example.smLent.domain.Alerts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertsRepository extends JpaRepository<Alerts, Long> {
    List<Alerts> findByBorrowerId(Long borrowerId);
    List<Alerts> findByLenderId(Long lenderId);
}
