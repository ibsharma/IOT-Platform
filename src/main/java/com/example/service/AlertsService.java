package com.example.service;

import com.example.dto.Alerts;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ishaan
 */
@Service
public interface AlertsService {
    public void create(Alerts alerts);
    public List<Alerts> getAlerts();
    public List<Alerts> getAlerts(Timestamp from, Timestamp to);
}
