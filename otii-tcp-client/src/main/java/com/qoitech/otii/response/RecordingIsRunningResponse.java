package com.qoitech.otii.response;

public class RecordingIsRunningResponse extends Response {
    public class RecordingIsRunningData {
        private boolean running = false;
        public boolean getRunning() { return this.running; }
        public void setRunning(boolean running) { this.running = running; }
    }

    private RecordingIsRunningData data = null;
    public RecordingIsRunningData getData() { return this.data; }
    public void setData(RecordingIsRunningData data) { this.data = data; }
}