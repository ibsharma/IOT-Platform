package com.example.dto;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * @author Ishaan
 */
@Entity("Metrics")
public class Metrics {

    public Metrics() {
        super();
    }

    public Metrics(ObjectId objectId, Double weight, Date creationDate) {
        super();
        this.objectId = objectId;
        this.weight = weight;
        this.creationDate = creationDate;
    }

    @Id
    private ObjectId objectId;
    private Date creationDate;
    private Double weight;

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
