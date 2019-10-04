package com.qoitech.otii.request;

public class ArcSetSupplyUsedCapacityData extends ArcData {
    private double value = 0.0;
    public double getValue() { return this.value; }

    public ArcSetSupplyUsedCapacityData(String deviceId, double value) {
        super(deviceId);
        this.value = value;
    }
}