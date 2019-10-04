package com.qoitech.otii.request;

public class ArcGetGpiData extends ArcData {
    private int pin = 0;
    public int getPin() { return this.pin; }

    public ArcGetGpiData(String deviceId, int pin) {
        super(deviceId);
        this.pin = pin;
    }
}