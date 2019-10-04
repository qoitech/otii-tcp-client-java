package com.qoitech.otii.request;

public class ArcSetUartBaudrateData extends ArcData {
    private int value;
    public double getValue() { return this.value; }

    public ArcSetUartBaudrateData(String deviceId, int value) {
        super(deviceId);
        this.value = value;
    }
}