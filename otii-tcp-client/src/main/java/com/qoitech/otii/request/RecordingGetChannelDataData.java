package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RecordingGetChannelDataData extends RecordingData {
    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }

    private String channel = null;
    public String getChannel() { return this.channel; }

    private int index = 0;
    public int getIndex() { return this.index; }

    private int count = 0;
    public int getCount() { return this.count; }

    public RecordingGetChannelDataData(int recordingId, String deviceId, String channel, int index, int count) {
        super(recordingId);
        this.deviceId = deviceId;
        this.channel = channel;
        this.index = index;
        this.count = count;
    }
}