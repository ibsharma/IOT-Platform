package com.example.dto;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * @author Ishaan
 */
@Entity("Alerts")
public class Alerts {

    public Alerts() {

        super();
    }

    public Alerts(ObjectId objectId, Double baseWeight, Double currentWeight, Date creationDate) {
        super();
        this.objectId = objectId;
        this.baseWeight = baseWeight;
        this.currentWeight = currentWeight;
        this.creationDate = creationDate;
    }

    @Id
    private ObjectId objectId;
    private Double baseWeight;
    private Double currentWeight;

    private String alertType;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



}
