package com.qoitech.otii.request;

public class ArcSetSupplySocTrackingData extends ArcData {
    private boolean enable = false;
    public boolean getEnable() { return this.enable; }

    public ArcSetSupplySocTrackingData(String deviceId, boolean enable) {
        super(deviceId);
        this.enable = enable;
    }
}