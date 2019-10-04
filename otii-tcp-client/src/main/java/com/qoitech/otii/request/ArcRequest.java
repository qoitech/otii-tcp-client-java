package com.qoitech.otii.request;

public class ArcRequest extends Request {
    private ArcData data = null;
    public ArcData getData() { return this.data; }

    public ArcRequest(String cmd, ArcData data) {
        super(cmd);
        this.data = data;
    }
}