package com.qoitech.otii.request;

public class ArcWriteTxData extends ArcData {
    private String value = null;
    public String getValue() { return this.value; }

    public ArcWriteTxData(String deviceId, String value) {
        super(deviceId);
        this.value = value;
    }
}