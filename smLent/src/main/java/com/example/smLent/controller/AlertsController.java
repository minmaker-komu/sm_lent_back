package com.example.smLent.controller;

import com.example.smLent.dto.AlertDto;
import com.example.smLent.service.AlertsService;
import org.springframework.web.bind.annotation.*;

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
}
