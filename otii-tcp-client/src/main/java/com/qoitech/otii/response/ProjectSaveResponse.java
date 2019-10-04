package com.qoitech.otii.response;

public class ProjectSaveResponse extends Response {
    public class ProjectSaveData {
        private String filename;
        public String getFilename() { return this.filename; }
        public void setFilename(String filename) { this.filename = filename; }
    }

    private ProjectSaveData data = null;
    public ProjectSaveData getData() { return this.data; }
    public void setData(ProjectSaveData data) { this.data = data; }
}