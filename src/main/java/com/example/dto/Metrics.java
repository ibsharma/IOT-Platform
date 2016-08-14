package com.example.dto;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.sql.Timestamp;

/**
 * @author Ishaan
 */
@Entity("Metrics")
public class Metrics {

    public Metrics() {
        super();
    }

    public Metrics(ObjectId objectId, Double weight, Timestamp creationTimestamp) {
        super();
        this.objectId = objectId;
        this.weight = weight;
        this.creationTimestamp = creationTimestamp;
    }

    @Id
    private ObjectId objectId;
    private Timestamp creationTimestamp;
    private Double weight;

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
