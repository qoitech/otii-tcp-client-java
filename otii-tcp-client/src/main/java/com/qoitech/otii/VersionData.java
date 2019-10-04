package com.qoitech.otii;

import com.fasterxml.jackson.annotation.*;

public class VersionData {
    private String hwVersion = null;
    @JsonGetter("hw_version") public String getHwVersion() { return this.hwVersion; }
    @JsonSetter("hw_version") public void setHwVersion(String hwVersion) { this.hwVersion = hwVersion; }

    private String fwVersion = null;
    @JsonGetter("fw_version") public String getFwVersion() { return this.fwVersion; }
    @JsonSetter("fw_version") public void setFwVersion(String fwVersion) { this.fwVersion = fwVersion; }
}