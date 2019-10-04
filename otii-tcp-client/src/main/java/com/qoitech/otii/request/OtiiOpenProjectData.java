package com.qoitech.otii.request;

public class OtiiOpenProjectData extends OtiiData {
    private String filename = null;
    public String getFilename() { return this.filename; }

    private boolean force = false;
    public boolean getForce() { return this.force; }

    private boolean progress = false;
    public boolean getProgress() { return this.progress; }

    public OtiiOpenProjectData(String filename, boolean force, boolean progress) {
        this.filename = filename;
        this.force = force;
        this.progress = progress;
    }
}