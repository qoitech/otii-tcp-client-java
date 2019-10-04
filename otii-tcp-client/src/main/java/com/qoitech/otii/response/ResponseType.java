package com.qoitech.otii.response;

public class ResponseType {
    public static final String RESPONSE = "response";
    public static final String PROGRESS = "progress";
    public static final String INFORMATION = "information";
    public static final String ERROR = "error";

    private String type = null;
    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }
}