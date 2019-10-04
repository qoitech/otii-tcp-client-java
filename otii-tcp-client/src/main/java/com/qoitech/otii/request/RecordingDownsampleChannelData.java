package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RecordingDownsampleChannelData extends RecordingData {
    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }

    private String channel = null;
    public String getChannel() { return this.channel; }

    private int factor = 1;
    public int getFactor() { return this.factor; }

    public RecordingDownsampleChannelData(int recordingId, String deviceId, String channel, int factor) {
        super(recordingId);
        this.deviceId = deviceId;
        this.channel = channel;
        this.factor = factor;
    }
}