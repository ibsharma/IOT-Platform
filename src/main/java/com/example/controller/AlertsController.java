package com.example.controller;

import com.example.dto.Alerts;
import com.example.service.AlertsService;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Ishaan
 */
@RestController
@RequestMapping("/alerts")
public class AlertsController {

    @Autowired
    AlertsService alertsService;

    @RequestMapping(value="/getAlerts", method = RequestMethod.GET, produces = "application/json")
    public List<Alerts> getAlerts() {
        return alertsService.getAlerts();
    }

    @RequestMapping(value="/getAlerts/from/{from}/to/{to}", method = RequestMethod.GET, produces = "application/json")
    public List<Alerts> getAlertsInATimeRange(@PathVariable String from, @PathVariable String to) {
        Timestamp fromTimestamp = new Timestamp(Long.parseLong(from));
        Date fromDate = new Date(fromTimestamp.getTime());
        Timestamp toTimestamp = new Timestamp(Long.valueOf(to));
        Date toDate = new Date(toTimestamp.getTime());
        return alertsService.getAlerts(fromDate, toDate);
    }
}
