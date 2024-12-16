package com.example.smLent.repository;

import com.example.smLent.domain.LentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LentItemRepository extends JpaRepository<LentItem, Long> {
    List<LentItem> findByMemberId(Long memberId);
}
