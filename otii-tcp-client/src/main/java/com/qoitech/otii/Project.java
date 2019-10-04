package com.qoitech.otii;

import java.io.IOException;

import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.OtiiClient.ErrorException;
import com.qoitech.otii.OtiiClient.TransIdException;
import com.qoitech.otii.request.*;
import com.qoitech.otii.response.ProgressHandler;
import com.qoitech.otii.response.ProjectGetLastRecordingResponse;
import com.qoitech.otii.response.ProjectGetRecordingsResponse;
import com.qoitech.otii.response.ProjectSaveResponse;

public class Project {
    private OtiiClient client = null;
    public void setOtiiClient(OtiiClient client) { this.client = client; }

    private int projectId;
    @JsonGetter("project_id") public int getProjectId() { return this.projectId; }
    @JsonSetter("project_id") public void setProjectId(int projectId) { this.projectId = projectId; }

    public void close(boolean force) throws IOException, TransIdException, ErrorException {
        client.request(new ProjectRequest("project_close", new ProjectCloseData(projectId, force)));
    }

    public void cropData(double start, double end) throws IOException, TransIdException, ErrorException {
        client.request(
            new ProjectRequest("project_crop_data", new ProjectCropDataData(projectId, start, end)),
            OtiiClient.NO_TIMEOUT);
    }

    public Recording getLastRecording() throws IOException, TransIdException, ErrorException {
         ProjectGetLastRecordingResponse response = client.request(
             new ProjectRequest("project_get_last_recording", new ProjectData(projectId)),
             ProjectGetLastRecordingResponse.class);
         Recording recording = response.getData();
         recording.setOtiiClient(client);
         return recording;
    }

    public Recording[] getRecordings() throws IOException, TransIdException, ErrorException {
        ProjectGetRecordingsResponse response = client.request(
            new ProjectRequest(
                "project_get_recordings", new ProjectData(projectId)), ProjectGetRecordingsResponse.class);
        Recording[] recordings = response.getData().getRecordings();
        for (Recording recording : recordings) {
            recording.setOtiiClient(client);
        }
        return recordings;
    }

    public String save(String filename, boolean force, ProgressHandler progressHandler)
            throws IOException, TransIdException, ErrorException {
        boolean progress = progressHandler != null;
        client.setProgressHandler(progressHandler);
        ProjectSaveResponse response = client.request(
            new ProjectRequest("project_save", new ProjectSaveData(projectId, filename, force, progress)),
            ProjectSaveResponse.class,
            OtiiClient.NO_TIMEOUT);
        client.setProgressHandler(null);
        return response.getData().getFilename();
    }

    public void startRecording() throws IOException, TransIdException, ErrorException {
        client.request(new ProjectRequest("project_start_recording", new ProjectData(projectId)));
    }

    public void stopRecording() throws IOException, TransIdException, ErrorException {
        client.request(new ProjectRequest("project_stop_recording", new ProjectData(projectId)));
    }
}
