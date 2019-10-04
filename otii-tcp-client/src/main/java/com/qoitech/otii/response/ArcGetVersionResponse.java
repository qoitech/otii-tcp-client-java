package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class ArcGetVersionResponse extends Response {
    private VersionData data = null;
    public VersionData getData() { return this.data; }
    public void setData(VersionData data) { this.data = data; }
}