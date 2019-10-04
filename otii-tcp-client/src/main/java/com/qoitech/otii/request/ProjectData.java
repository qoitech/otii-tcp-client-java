package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ProjectData {
    private int projectId = -1;
    @JsonGetter("project_id") public int getProjectId() { return this.projectId; }

    public ProjectData(int projectId) {
        this.projectId = projectId;
    }
}