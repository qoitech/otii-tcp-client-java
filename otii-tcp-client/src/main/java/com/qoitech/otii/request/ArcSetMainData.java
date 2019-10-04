package com.qoitech.otii.request;

public class ArcSetMainData extends ArcData {
    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public ArcSetMainData(String deviceId, boolean enable) {
        super(deviceId);
        this.enable = enable;
    }
}