package com.qoitech.otii.data;

public class DigitalValue {
    private double timestamp = 0.0;
    private boolean value = false;

    public double getTimestamp() { return this.timestamp; }
    public void setTimestamp(double timestamp) { this.timestamp = timestamp; }

    public boolean getValue() { return this.value; }
    public void setValues(boolean value) { this.value = value; }
}