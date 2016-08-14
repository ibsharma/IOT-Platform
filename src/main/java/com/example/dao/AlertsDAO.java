package com.example.dao;

import com.example.dto.Alerts;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Ishaan
 */
@Repository
public interface AlertsDAO {

    public void create(Alerts alerts);
    public List<Alerts> getAlerts();
    public List<Alerts> getAlerts(Date from, Date to);
}
