package com.qoitech.otii.request;

public class ArcSetAdcResistorData extends ArcData {
    private double value;
    public double getValue() { return this.value; }

    public ArcSetAdcResistorData(String deviceId, double value) {
        super(deviceId);
        this.value = value;
    }
}