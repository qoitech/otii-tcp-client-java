package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ArcData {
    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }

    public ArcData(String deviceId) {
        this.deviceId = deviceId;
    }
}