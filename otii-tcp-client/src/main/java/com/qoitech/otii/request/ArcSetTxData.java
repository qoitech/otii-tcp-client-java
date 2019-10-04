package com.qoitech.otii.request;

public class ArcSetTxData extends ArcData {
    private boolean value = false;
    public boolean getValue() { return this.value; }

    public ArcSetTxData(String deviceId, boolean value) {
        super(deviceId);
        this.value = value;
    }
}