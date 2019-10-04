package com.qoitech.otii.data;

import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.response.Response;

public class DigitalData extends Response {
    private String dataType = null;
    private DigitalValue[] values = null;

    @JsonGetter("data_type")
    public String getDataType() { return this.dataType; }
    @JsonSetter("data_type")
    public void setDataType(String dataType) { this.dataType = dataType; }

    public DigitalValue[] getValues() { return this.values; }
    public void setValues(DigitalValue[] values) { this.values = values; }
}