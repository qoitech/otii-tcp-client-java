package com.qoitech.otii.response;

import com.qoitech.otii.data.LogData;

public class RecordingGetLogChannelDataResponse extends Response {
    private LogData data = null;
    public LogData getData() { return this.data; }
    public void setData(LogData data) { this.data = data; }
}