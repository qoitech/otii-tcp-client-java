package com.qoitech.otii.request;

public class OtiiSetAllMainData extends OtiiData {
    private boolean enable;
    public boolean getEnable() { return this.enable; }

    public OtiiSetAllMainData(boolean enable) {
        this.enable = enable;
    }
}