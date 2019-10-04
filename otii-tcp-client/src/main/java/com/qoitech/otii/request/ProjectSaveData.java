package com.qoitech.otii.request;

public class ProjectSaveData extends ProjectData {
    private String filename = null;
    public String getFilename() { return this.filename; }

    private boolean force = false;
    public boolean getForce() { return this.force; }

    private boolean progress = false;
    public boolean getProgress() { return this.progress; }

    public ProjectSaveData(int projectId, String filename, boolean force, boolean progress) {
        super(projectId);
        this.filename = filename;
        this.force = force;
        this.progress = progress;
    }
}