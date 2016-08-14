package com.example;

/**
 * @author Ishaan
 */
public class MetricsIntermediate {

    Long timeStamp;
    Double value;

    public MetricsIntermediate(Long timeStamp, Double value) {
        super();
        this.timeStamp = timeStamp;
        this.value = value;
    }

    public MetricsIntermediate() {
        super();
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
