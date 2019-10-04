package com.qoitech.otii.request;

public class ArcSetMaxCurrentData extends ArcData {
    private double value;
    public double getValue() { return this.value; }

    public ArcSetMaxCurrentData(String deviceId, double value) {
        super(deviceId);
        this.value = value;
    }
}