package com.example.service.Impl;

import com.example.dao.MetricsDAO;
import com.example.dto.Metrics;
import com.example.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ishaan
 */
@Service
public class MetricsServiceImpl implements MetricsService{

    @Autowired
    private MetricsDAO metricsDAO;

    @Override
    public void create(Metrics metrics) {
        metricsDAO.create(metrics);
    }

    @Override
    public List<Metrics> getMetrics() {
        return metricsDAO.getMetrics();
    }

    @Override
    public List<Metrics> getMetrics(Date from, Date to) {
        return metricsDAO.getMetrics(from, to);
    }
}
