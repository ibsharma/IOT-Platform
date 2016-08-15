package com.example.service.Impl;

import com.example.dao.AlertsDAO;
import com.example.dto.Alerts;
import com.example.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ishaan
 */
@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    private AlertsDAO alertsDAO;

    @Override
    public void create(Alerts alerts) {
        alertsDAO.create(alerts);
    }

    @Override
    public List<Alerts> getAlerts() {
        return alertsDAO.getAlerts();
    }

    @Override
    public List<Alerts> getAlerts(Timestamp from, Timestamp to) {
        return alertsDAO.getAlerts(from, to);
    }
}
