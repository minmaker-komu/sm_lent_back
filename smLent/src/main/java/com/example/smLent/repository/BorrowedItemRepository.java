package com.example.smLent.repository;

import com.example.smLent.domain.BorrowedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedItemRepository extends JpaRepository<BorrowedItem, Long> {
    List<BorrowedItem> findByMemberId(Long memberId);
}
