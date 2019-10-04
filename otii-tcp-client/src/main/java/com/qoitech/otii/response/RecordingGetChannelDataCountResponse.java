package com.qoitech.otii.response;

public class RecordingGetChannelDataCountResponse extends Response {
    public class RecordingGetChannelDataCountData {
        private int count = 0;
        public int getCount() { return this.count; }
        public void setCount(int count) { this.count = count; }
    }

    private RecordingGetChannelDataCountData data = null;
    public RecordingGetChannelDataCountData getData() { return this.data; }
    public void setData(RecordingGetChannelDataCountData data) { this.data = data; }
}