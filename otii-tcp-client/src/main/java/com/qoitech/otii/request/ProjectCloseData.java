package com.qoitech.otii.request;

public class ProjectCloseData extends ProjectData {
    private boolean force = false;
    public boolean getForce() { return this.force; }

    public ProjectCloseData(int projectId, boolean force) {
        super(projectId);
        this.force = force;
    }
}