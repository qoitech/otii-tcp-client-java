package com.qoitech.otii.request;

public class RecordingRequest extends Request {
    private RecordingData data = null;
    public RecordingData getData() { return this.data; }

    public RecordingRequest(String cmd, RecordingData data) {
        super(cmd);
        this.data = data;
    }
}