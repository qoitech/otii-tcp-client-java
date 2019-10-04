package com.qoitech.otii.request;

public class RecordingRenameData extends RecordingData {
    private String name = null;
    public String getName() { return this.name; }

    public RecordingRenameData(int recordingId, String name) {
        super(recordingId);
        this.name = name;
    }
}