package com.qoitech.otii.request;

public class ArcEnable5vData extends ArcData {
    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public ArcEnable5vData(String deviceId, boolean enable) {
        super(deviceId);
        this.enable = enable;
    }
}