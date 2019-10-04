package com.qoitech.otii.response;

import com.qoitech.otii.data.DigitalData;

public class RecordingGetDigitalChannelDataResponse extends Response {
    private DigitalData data = null;
    public DigitalData getData() { return this.data; }
    public void setData(DigitalData data) { this.data = data; }
}