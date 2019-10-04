package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class OtiiGetDevicesResponse extends Response {
    public class OtiiGetDevicesData {
        private Arc[] devices = null;
        public Arc[] getDevices() { return this.devices; }
        public void setDevices(Arc[] devices) { this.devices = devices; }
    }

    private OtiiGetDevicesData data = null;
    public OtiiGetDevicesData getData() { return this.data; }
    public void setData(OtiiGetDevicesData data) { this.data = data; }
}