package com.example.smLent.controller;

import com.example.smLent.domain.AlertStatus;
import com.example.smLent.dto.AlertDto;
import com.example.smLent.service.AlertsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertsController {

    private final AlertsService alertsService;

    public AlertsController(AlertsService alertsService) {
        this.alertsService = alertsService;
    }

    @PostMapping
    public AlertDto createAlert(@RequestBody AlertDto alertDto) {
        return alertsService.createAlert(alertDto);
    }

    @GetMapping
    public List<AlertDto> getAlertsByUserId(@RequestParam Long userId) {
        return alertsService.getAlertsByUserId(userId);
    }

    @PatchMapping("/{id}")
    public void updateAlertStatus(@PathVariable Long id, @RequestParam AlertStatus status) {
        alertsService.updateAlertStatus(id, status);
    }
}
