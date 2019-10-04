package com.qoitech.otii.response;

public class RecordingGetChannelDataIndexResponse extends Response {
    public class RecordingGetChannelDataIndexData {
        private int index = 0;
        public int getIndex() { return this.index; }
        public void setCount(int index) { this.index = index; }
    }

    private RecordingGetChannelDataIndexData data = null;
    public RecordingGetChannelDataIndexData getData() { return this.data; }
    public void setData(RecordingGetChannelDataIndexData data) { this.data = data; }
}