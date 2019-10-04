package com.qoitech.otii.request;

public class ArcEnableChannelData extends ArcData {
    private String channel;
    public String getChannel() { return this.channel; }

    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public ArcEnableChannelData(String deviceId, String channel, boolean enable) {
        super(deviceId);
        this.channel = channel;
        this.enable = enable;
    }
}