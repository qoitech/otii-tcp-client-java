package com.qoitech.otii.request;

public class ArcSetMainVoltageData extends ArcData {
    private double value;
    public double getValue() { return this.value; }

    public ArcSetMainVoltageData(String deviceId, double value) {
        super(deviceId);
        this.value = value;
    }
}