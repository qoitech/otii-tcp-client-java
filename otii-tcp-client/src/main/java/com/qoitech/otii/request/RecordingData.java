package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RecordingData {
    private int recordingId = -1;
    @JsonGetter("recording_id") public int getRecordingId() { return this.recordingId; }

    public RecordingData(int recordingId) {
        this.recordingId = recordingId;
    }
}