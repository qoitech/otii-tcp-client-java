package com.qoitech.otii.request;

public class ArcSetRangeData extends ArcData {
    private String range = null;
    public String getRange() { return this.range; }

    public ArcSetRangeData(String deviceId, String range) {
        super(deviceId);
        this.range = range;
    }
}