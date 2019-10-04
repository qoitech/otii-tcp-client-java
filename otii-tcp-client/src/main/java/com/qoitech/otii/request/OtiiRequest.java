package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtiiRequest extends Request {
    private OtiiData data = null;
    public OtiiData getData() { return this.data; }

    public OtiiRequest(String cmd) {
        super(cmd);
    }

    public OtiiRequest(String cmd, OtiiData data) {
        super(cmd);
        this.data = data;
    }
}