package com.qoitech.otii.request;

public class ArcSetExpVoltageData extends ArcData {
    private double value;
    public double getValue() { return this.value; }

    public ArcSetExpVoltageData(String deviceId, double value) {
        super(deviceId);
        this.value = value;
    }
}