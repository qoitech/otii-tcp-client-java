package com.qoitech.otii.response;

import com.qoitech.otii.data.AnalogData;

public class RecordingGetAnalogChannelDataResponse extends Response {
    private AnalogData data = null;
    public AnalogData getData() { return this.data; }
    public void setData(AnalogData data) { this.data = data; }
}