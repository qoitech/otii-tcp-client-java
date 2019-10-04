package com.qoitech.otii.request;

public class ArcSetGpoData extends ArcData {
    private int pin = 0;
    public int getPin() { return this.pin; }

    private boolean value = false;
    public boolean getValue() { return this.value; }

    public ArcSetGpoData(String deviceId, int pin, boolean value) {
        super(deviceId);
        this.pin = pin;
        this.value = value;
    }
}