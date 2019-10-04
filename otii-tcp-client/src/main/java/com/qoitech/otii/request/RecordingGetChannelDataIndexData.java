package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RecordingGetChannelDataIndexData extends RecordingData {
    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }

    private String channel = null;
    public String getChannel() { return this.channel; }

    private double timestamp = 0.0;
    public double getTimestamp() { return this.timestamp; }

    public RecordingGetChannelDataIndexData(int recordingId, String deviceId, String channel, double timestamp) {
        super(recordingId);
        this.deviceId = deviceId;
        this.channel = channel;
        this.timestamp = timestamp;
    }
}