package com.example.dto;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.sql.Timestamp;

/**
 * @author Ishaan
 */
@Entity("Alerts")
public class Alerts {

    public Alerts() {
        super();
    }

    public Alerts(ObjectId objectId, Double baseWeight, Double currentWeight, Timestamp creationTimestamp, String alertType) {
        super();
        this.objectId = objectId;
        this.baseWeight = baseWeight;
        this.currentWeight = currentWeight;
        this.creationTimestamp = creationTimestamp;
        this.alertType = alertType;
    }

    @Id
    private ObjectId objectId;
    private Double baseWeight;
    private Double currentWeight;

    private String alertType;
    private Timestamp creationTimestamp;

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
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

    public Timestamp getTimestamp() {
        return creationTimestamp;
    }

    public void setTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }



}
