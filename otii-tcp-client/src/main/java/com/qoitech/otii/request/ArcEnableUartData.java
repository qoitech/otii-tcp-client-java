package com.qoitech.otii.request;

public class ArcEnableUartData extends ArcData {
    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public ArcEnableUartData(String deviceId, boolean enable) {
        super(deviceId);
        this.enable = enable;
    }
}