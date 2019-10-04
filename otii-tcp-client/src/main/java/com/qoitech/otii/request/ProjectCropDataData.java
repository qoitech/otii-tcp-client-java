package com.qoitech.otii.request;

public class ProjectCropDataData extends ProjectData {
    private double start = 0.0;
    public double getStart() { return this.start; }
    public void setStart(double start) { this.start = start; }

    private double end = 0.0;
    public double getEnd() { return this.end; }
    public void setEnd(double end) { this.end = end; }

    public ProjectCropDataData(int projectId, double start, double end) {
        super(projectId);
        this.start = start;
        this.end = end;
    }
}