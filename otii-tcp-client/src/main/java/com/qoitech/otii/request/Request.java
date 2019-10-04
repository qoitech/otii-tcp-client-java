package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.*;

public class Request {
    private String type = null;
    public String getType() { return this.type; }

    private String cmd = null;
    public String getCmd() { return this.cmd; }

    private String transId = null;
    @JsonGetter("trans_id") public String getTransId() { return this.transId; }
    @JsonSetter("trans_id") public void setTransId(String transId) { this.transId = transId; }

    public Request(String cmd) {
        this.type = "request";
        this.cmd = cmd;
        this.transId = null;
    }
}