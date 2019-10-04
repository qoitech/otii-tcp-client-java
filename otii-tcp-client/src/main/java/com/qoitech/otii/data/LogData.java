package com.qoitech.otii.data;

import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.response.Response;

public class LogData extends Response {
    private String dataType = null;
    private LogValue[] values = null;

    @JsonGetter("data_type")
    public String getDataType() { return this.dataType; }
    @JsonSetter("data_type")
    public void setDataType(String dataType) { this.dataType = dataType; }

    public LogValue[] getValues() { return this.values; }
    public void setValues(LogValue[] values) { this.values = values; }
}