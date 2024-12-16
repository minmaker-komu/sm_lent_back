package com.example.smLent.service;

import com.example.smLent.domain.*;
import com.example.smLent.dto.AlertDto;
import com.example.smLent.repository.AlertsRepository;
import com.example.smLent.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertsService {

    private final AlertsRepository alertsRepository;

    public AlertsService(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    public AlertDto createAlert(AlertDto alertDto) {
        Alerts alert = new Alerts();
        alert.setStatus(alertDto.getStatus());

        Alerts savedAlert = alertsRepository.save(alert);

        alertDto.setId(savedAlert.getId());
        return alertDto;
    }
}
