package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class OtiiGetActiveProjectResponse extends Response {
    private Project data = null;
    public Project getData() { return this.data; }
    public void setData(Project data) { this.data = data; }
}