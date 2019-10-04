package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class OtiiOpenProjectResponse extends Response {
    public class OpenProjectData extends Project {
        private String filename = null;
        public String getFilename() { return this.filename; }
        public void setFilename(String filename) { this.filename = filename; }
    }

    private OpenProjectData data = null;
    public OpenProjectData getData() { return this.data; }
    public void setData(OpenProjectData data) { this.data = data; }
}