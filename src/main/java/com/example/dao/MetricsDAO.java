package com.example.dao;

import com.example.dto.Metrics;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Ishaan
 */
@Repository
public interface MetricsDAO {
    public void create(Metrics metrics);
    public List<Metrics> getMetrics();
    public List<Metrics> getMetrics(Date from, Date to);
}
