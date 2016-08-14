package com.example.dao;

import com.example.dto.Metrics;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ishaan
 */
@Repository
public interface MetricsDAO {
    public void create(Metrics metrics);
    public List<Metrics> getMetrics();
    public List<Metrics> getMetrics(Timestamp from, Timestamp to);
}
