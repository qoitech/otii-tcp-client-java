package com.qoitech.otii.response;

import com.fasterxml.jackson.annotation.*;

public class InformationResponse extends ResponseType {
    public class InformationData {
        private String otiiVersion = null;
        @JsonGetter("otii_version") public String getOtiiVersion() { return this.otiiVersion; }
        @JsonSetter("otii_version") public void setOtiiVersion(String otiiVersion) { this.otiiVersion = otiiVersion; }

        private String protocolVersion = null;
        @JsonGetter("protocol_version") public String getProtocolVersion() { return this.protocolVersion; }
        @JsonSetter("protocol_version") public void setProtocolVersion(String protocolVersion) { this.protocolVersion = protocolVersion; }

        private String server = null;
        public String getServer() { return this.server; }
        public void setServer(String server) { this.server = server; }
    }

    private String info = null;
    public String getInfo() { return this.info; }
    public void setInfo(String info) { this.info = info; }

    private InformationData  data = null;
    public InformationData getData() { return this.data; }
    public void setData(InformationData data) { this.data = data; }
}