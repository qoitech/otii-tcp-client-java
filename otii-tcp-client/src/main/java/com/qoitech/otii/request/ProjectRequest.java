package com.qoitech.otii.request;

public class ProjectRequest extends Request {
    private ProjectData data = null;
    public ProjectData getData() { return this.data; }

    public ProjectRequest(String cmd, ProjectData data) {
        super(cmd);
        this.data = data;
    }
}