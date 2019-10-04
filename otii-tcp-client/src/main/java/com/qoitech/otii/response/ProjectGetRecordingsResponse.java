package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class ProjectGetRecordingsResponse extends Response {
    public class ProjectGetRecordingsData {
        private Recording[] recordings = null;
        public Recording[] getRecordings() { return this.recordings; }
        public void setRecordings(Recording[] recordings) { this.recordings = recordings; }
    }

    private ProjectGetRecordingsData data = null;
    public ProjectGetRecordingsData getData() { return this.data; }
    public void setData(ProjectGetRecordingsData data) { this.data = data; }
}