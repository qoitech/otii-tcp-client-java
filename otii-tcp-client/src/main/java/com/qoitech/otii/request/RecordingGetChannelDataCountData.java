package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RecordingGetChannelDataCountData extends RecordingData {
    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }

    private String channel = null;
    public String getChannel() { return this.channel; }

    public RecordingGetChannelDataCountData(int recordingId, String deviceId, String channel) {
        super(recordingId);
        this.deviceId = deviceId;
        this.channel = channel;
    }
}