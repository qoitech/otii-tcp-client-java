package com.qoitech.otii.data;

import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.response.Response;

public class AnalogData extends Response {
    private String dataType = null;
    private double timestamp = 0.0;
    private double interval = 0.0;
    private double[] values = null;

    @JsonGetter("data_type")
    public String getDataType() { return this.dataType; }
    @JsonSetter("data_type")
    public void setDataType(String dataType) { this.dataType = dataType; }

    public double getTimestamp() { return this.timestamp; }
    public void setTimestamp(double timestamp) { this.timestamp = timestamp; }

    public double getInterval() { return this.interval; }
    public void setInterval(double interval) { this.interval = interval; }

    public double[] getValues() { return this.values; }
    public void setValues(double[] values) { this.values = values; }
}