package com.example.controller;

import com.example.MetricsIntermediate;
import com.example.Rules.RulesService;
import com.example.dto.Metrics;
import com.example.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

import java.util.List;

/**
 * @author Ishaan
 */
@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    RulesService rulesService;

    @Autowired
    MetricsService metricsService;

    @RequestMapping(value = "/create/baseweight/{baseWeight}", method = RequestMethod.POST, produces = "application/json")
    public void create(@RequestBody MetricsIntermediate metricsIntermediate, @PathVariable("baseWeight") Double baseWeight) {
        Timestamp timestamp = new Timestamp(metricsIntermediate.getTimeStamp());
        Metrics metrics = new Metrics(null, metricsIntermediate.getValue(), timestamp);
        metricsService.create(metrics);
        rulesService.executeRules(baseWeight, metricsIntermediate.getValue());
    }

    @RequestMapping(value = "/retrieve", method = RequestMethod.GET, produces = "application/json")
    public List<Metrics> retrieve() {
        return metricsService.getMetrics();
    }

    @RequestMapping(value = "/retrieve/from/{from}/to/{to}", method = RequestMethod.GET, produces = "application/json")
    public List<Metrics> retrieveByTimeRange(@PathVariable("from") String from,
                                            @PathVariable("to") String to) {
        Timestamp fromTimestamp = new Timestamp(Long.valueOf(from));
        Timestamp toTimestamp = new Timestamp(Long.valueOf(to));
        return metricsService.getMetrics(fromTimestamp, toTimestamp);
    }
}
