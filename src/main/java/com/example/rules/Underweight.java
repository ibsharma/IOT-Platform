package com.example.rules;

import com.example.dto.Alerts;
import com.example.service.AlertsService;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @author Ishaan
 */
@Rule(name="underweight")
public class Underweight {
    @Autowired
    AlertsService alertsService;

    private Double baseWeight;
    private Double currentWeight;
    private String alertType;

    public Underweight(Double baseWeight, Double currentWeight, String alertType) {
        super();
        this.baseWeight = baseWeight;
        this.currentWeight = currentWeight;
        this.alertType = alertType;
    }

    public Underweight() {
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public Double getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(Double baseWeight) {
        this.baseWeight = baseWeight;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Condition
    public boolean when() {
        if(currentWeight < baseWeight) {
            Double weightGainpercentage = ((baseWeight - currentWeight) / baseWeight)*100;
            if(weightGainpercentage >= 10.0D) {
                return true;
            } else {
                return false;
            }
        } else
           return false;
    }

    @Action(order = 1)
    public void then() throws Exception {
        Alerts alerts = new Alerts(null, baseWeight, currentWeight, new Timestamp(System.currentTimeMillis()), alertType);
        alertsService.create(alerts);
    }
}
