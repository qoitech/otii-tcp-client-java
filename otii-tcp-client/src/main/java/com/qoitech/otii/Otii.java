package com.qoitech.otii;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qoitech.otii.OtiiClient.*;
import com.qoitech.otii.response.*;
import com.qoitech.otii.request.*;

public class Otii {
    private OtiiClient client;

    Otii(OtiiClient client) {
        this.client = client;
    }

    public Project createProject() throws IOException, TransIdException, ErrorException {
        OtiiCreateProjectResponse response = client.request(
            new OtiiRequest("otii_create_project"), OtiiCreateProjectResponse.class);
        Project project = response.getData();
        project.setOtiiClient(client);
        return project.getProjectId() != -1 ? project : null;
    }

    public Project getActiveProject() throws IOException, TransIdException, ErrorException {
        OtiiGetActiveProjectResponse response = client.request(
            new OtiiRequest("otii_get_active_project"), OtiiGetActiveProjectResponse.class);
        Project project = response.getData();
        project.setOtiiClient(client);
        return project.getProjectId() != -1 ? project : null;
    }

    public Arc[] getDevices() throws IOException, TransIdException, ErrorException {
        OtiiGetDevicesResponse response = client.request(
            new OtiiRequest("otii_get_devices"), OtiiGetDevicesResponse.class);
        Arc[] devices = response.getData().getDevices();
        List<Arc> arcs = new ArrayList<Arc>();
        for (Arc arc : devices) {
            if (arc.getType().equals("Arc")) {
                arc.setOtiiClient(client);
                arcs.add(arc);
            }
        }
        Arc[] array = new Arc[arcs.size()];
        arcs.toArray(array);
        return array;
    }

    public Project openProject(String filename, boolean force, ProgressHandler progressHandler)
            throws IOException, TransIdException, ErrorException {
        boolean progress = progressHandler != null;
        client.setProgressHandler(progressHandler);
        OtiiOpenProjectResponse response = client.request(
            new OtiiRequest("otii_open_project", new OtiiOpenProjectData(filename, force, progress)),
            OtiiOpenProjectResponse.class,
            OtiiClient.NO_TIMEOUT);
        client.setProgressHandler(null);
        Project project = response.getData();
        project.setOtiiClient(client);
        return project.getProjectId() != -1 ? project : null;
    }

    public void setAllMain(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new OtiiRequest("otii_set_all_main", new OtiiSetAllMainData(enable)));
    }
}