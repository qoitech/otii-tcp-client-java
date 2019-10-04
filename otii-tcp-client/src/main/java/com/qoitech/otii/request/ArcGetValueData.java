package com.qoitech.otii.request;

public class ArcGetValueData extends ArcData {
    private String channel = null;
    public String getChannel() { return this.channel; }
    public ArcGetValueData(String deviceId, String channel) {
        super(deviceId);
        this.channel = channel;
    }
}