package com.example.service;

import com.example.dto.Metrics;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ishaan
 */
@Service
public interface MetricsService {
    public void create(Metrics metrics);
    public List<Metrics> getMetrics();
    public List<Metrics> getMetrics(Date from, Date to);
}
