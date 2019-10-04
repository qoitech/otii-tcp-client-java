package com.qoitech.otii.response;

import com.fasterxml.jackson.annotation.*;

public class ProgressResponse extends Response {
    private double progressValue = 0;
    @JsonGetter("progress_value") public double getProgressValue() { return this.progressValue; }
    @JsonSetter("progress_value") public void setProgressValue(double progressValue) { this.progressValue = progressValue; }
}