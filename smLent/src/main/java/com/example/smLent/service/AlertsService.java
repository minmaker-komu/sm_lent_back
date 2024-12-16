package com.example.smLent.service;

import com.example.smLent.domain.Alerts;
import com.example.smLent.domain.AlertStatus;
import com.example.smLent.domain.Item;
import com.example.smLent.domain.Member;
import com.example.smLent.dto.AlertDto;
import com.example.smLent.repository.AlertsRepository;
import com.example.smLent.repository.ItemRepository;
import com.example.smLent.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertsService {

    private final AlertsRepository alertsRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public AlertsService(AlertsRepository alertsRepository, ItemRepository itemRepository, MemberRepository memberRepository) {
        this.alertsRepository = alertsRepository;
        this.itemRepository = itemRepository;
        this.memberRepository = memberRepository;
    }

    /**
     * 알림 생성
     */
    @Transactional
    public AlertDto createAlert(AlertDto alertDto) {
        Item item = itemRepository.findById(alertDto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Member lender = memberRepository.findById(alertDto.getLenderId())
                .orElseThrow(() -> new RuntimeException("Lender not found"));

        Member borrower = memberRepository.findById(alertDto.getBorrowerId())
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        Alerts alert = new Alerts();
        alert.setItem(item);
        alert.setLender(lender);
        alert.setBorrower(borrower);
        alert.setStatus(AlertStatus.대기);

        Alerts savedAlert = alertsRepository.save(alert);

        return new AlertDto(
                savedAlert.getId(),
                savedAlert.getItem().getId(),
                savedAlert.getLender().getId(),
                savedAlert.getBorrower().getId(),
                savedAlert.getStatus(),
                savedAlert.getCreatedAt()
        );
    }

    /**
     * 알림 조회
     */
    @Transactional(readOnly = true)
    public List<AlertDto> getAlertsByUserId(Long userId) {
        return alertsRepository.findByBorrowerId(userId).stream()
                .map(alert -> new AlertDto(
                        alert.getId(),
                        alert.getItem().getId(),
                        alert.getLender().getId(),
                        alert.getBorrower().getId(),
                        alert.getStatus(),
                        alert.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    /**
     * 알림 상태 업데이트
     */
    @Transactional
    public void updateAlertStatus(Long alertId, AlertStatus status) {
        Alerts alert = alertsRepository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setStatus(status);
        alertsRepository.save(alert);
    }
}
