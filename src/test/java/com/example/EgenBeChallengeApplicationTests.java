package com.example;

import com.example.controller.AlertsController;
import com.example.controller.MetricsController;
import com.example.dto.Alerts;
import com.example.dto.Metrics;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest

public class EgenBeChallengeApplicationTests {

	@Autowired
	AlertsController alertsController;

	@Autowired
	MetricsController metricsController;

	@Test
	public void testGetMetrics() {
		List<Metrics> metricList = metricsController.getMetrics();
		Assert.assertTrue(metricList.size() > 0);
	}

	@Test
	public void testGetAlerts() {
		List<Alerts> alertsList = alertsController.getAlerts();
		Assert.assertTrue(alertsList.size() > 0);
	}

	@Test
	public void testGetAlertsInATimeRange() {
		List<Alerts> alertsList = alertsController.getAlertsInATimeRange("760596447","760596445");
		Assert.assertTrue(alertsList.size() == 0);
	}

	@Test
	public void testGetMetricssInATimeRange() {
		List<Metrics> metricsList = metricsController.getMetricsByTimeRange("760596447","760596445");
		Assert.assertTrue(metricsList.size() == 0);
	}

	@Test
	public void testCreateMetricsOfOverWeight() {
		Double baseWeight = 90D;
		Double currentWeight = 400D;
		boolean flag = true;
		MetricsIntermediate metricsIntermediate = new MetricsIntermediate(760596446L, 120D);
		metricsController.create(metricsIntermediate, baseWeight);
		List<Metrics> listOfMetrics = metricsController.getMetricsByTimeRange("760596445", "760596447");
		List<Alerts> listOfAlerts = alertsController.getAlerts();

		for(Alerts alerts : listOfAlerts) {
			if(alerts.getBaseWeight() == baseWeight && alerts.getCurrentWeight() == currentWeight && alerts.getAlertType().equalsIgnoreCase("Overweight")) {
				flag = false;
				break;
			}
		}
		Assert.assertTrue(listOfMetrics.size() > 0);
		Assert.assertTrue(flag);
	}

	@Test
	public void testCreateMetricOfUnderWeight() {
		Double baseWeight = 50D;
		Double currentWeight = 70D;
		boolean flag = true;
		MetricsIntermediate metricsIntermediate = new MetricsIntermediate(760596446L, 120D);
		metricsController.create(metricsIntermediate, baseWeight);
		List<Metrics> listOfMetrics = metricsController.getMetricsByTimeRange("760596445", "760596447");
		List<Alerts> listOfAlerts = alertsController.getAlerts();

		for(Alerts alerts : listOfAlerts) {
			if(alerts.getBaseWeight() == baseWeight && alerts.getCurrentWeight() == currentWeight && alerts.getAlertType().equalsIgnoreCase("Underweight")) {
				flag = false;
				break;
			}
		}
		Assert.assertTrue(listOfMetrics.size() > 0);
		Assert.assertTrue(flag);
	}

}
