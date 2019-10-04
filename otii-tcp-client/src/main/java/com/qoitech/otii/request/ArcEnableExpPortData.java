package com.qoitech.otii.request;

public class ArcEnableExpPortData extends ArcData {
    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public ArcEnableExpPortData(String deviceId, boolean enable) {
        super(deviceId);
        this.enable = enable;
    }
}