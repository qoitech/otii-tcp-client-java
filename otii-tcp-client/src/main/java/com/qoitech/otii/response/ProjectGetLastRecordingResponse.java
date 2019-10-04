package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class ProjectGetLastRecordingResponse extends Response {
    private Recording data = null;
    public Recording getData() { return this.data; }
    public void setData(Recording data) { this.data = data; }
}