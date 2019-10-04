package com.qoitech.otii;

import java.io.IOException;

import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.OtiiClient.ErrorException;
import com.qoitech.otii.OtiiClient.TransIdException;
import com.qoitech.otii.data.*;
import com.qoitech.otii.request.*;
import com.qoitech.otii.response.*;

public class Recording {
    private OtiiClient client = null;
    public void setOtiiClient(OtiiClient client) { this.client = client; }

    private int recordingId;
    @JsonGetter("recording_id") public int getRecordingId() { return this.recordingId; }
    @JsonSetter("recording_id") public void setRecordingId(int recordingId) { this.recordingId = recordingId; }

    private String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private boolean running;
    public boolean getRunning() { return this.running; }
    public void setRunning(boolean running) { this.running = running; }

    public void delete() throws IOException, TransIdException, ErrorException {
        client.request(new RecordingRequest("recording_delete", new RecordingData(recordingId)));
    }

    public void downsampleChannel(String deviceId, String channel, int factor) throws IOException, TransIdException, ErrorException {
        client.request(new RecordingRequest(
            "recording_downsample_channel",
            new RecordingDownsampleChannelData(recordingId, deviceId, channel, factor)),
            OtiiClient.NO_TIMEOUT);
    }

    public int getChannelDataCount(String deviceId, String channel) throws IOException, TransIdException, ErrorException {
        RecordingGetChannelDataCountResponse response = client.request(
            new RecordingRequest(
                "recording_get_channel_data_count",
                new RecordingGetChannelDataCountData(recordingId, deviceId, channel)),
            RecordingGetChannelDataCountResponse.class);
        return response.getData().getCount();
    }

    public int getChannelDataIndex(String deviceId, String channel, double timestamp) throws IOException, TransIdException, ErrorException {
        RecordingGetChannelDataIndexResponse response = client.request(
                new RecordingRequest(
                    "recording_get_channel_data_index",
                    new RecordingGetChannelDataIndexData(recordingId, deviceId, channel, timestamp)),
                RecordingGetChannelDataIndexResponse.class);
        return response.getData().getIndex();
    }

    public AnalogData getAnalogChannelData(String deviceId, String channel, int index, int count) throws IOException, TransIdException, ErrorException {
        RecordingGetAnalogChannelDataResponse response = client.request(
                new RecordingRequest(
                    "recording_get_channel_data",
                    new RecordingGetChannelDataData(recordingId, deviceId, channel, index, count)),
                RecordingGetAnalogChannelDataResponse.class,
                OtiiClient.NO_TIMEOUT);
        return response.getData();
    }

    public DigitalData getDigitalChannelData(String deviceId, String channel, int index, int count) throws IOException, TransIdException, ErrorException {
        RecordingGetDigitalChannelDataResponse response = client.request(
                new RecordingRequest(
                    "recording_get_channel_data",
                    new RecordingGetChannelDataData(recordingId, deviceId, channel, index, count)),
                RecordingGetDigitalChannelDataResponse.class,
                OtiiClient.NO_TIMEOUT);
        return response.getData();
    }

    public LogData getLogChannelData(String deviceId, String channel, int index, int count) throws IOException, TransIdException, ErrorException {
        return getLogChannelData(deviceId, channel, index, count, true);
    }

    public LogData getLogChannelData(String deviceId, String channel, int index, int count, boolean strip) throws IOException, TransIdException, ErrorException {
        RecordingGetLogChannelDataResponse response = client.request(
                new RecordingRequest(
                    "recording_get_channel_data",
                    new RecordingGetChannelDataData(recordingId, deviceId, channel, index, count)),
                RecordingGetLogChannelDataResponse.class,
                OtiiClient.NO_TIMEOUT);

        LogData data = response.getData();
        if (strip) {
            LogValue[] values = data.getValues();
            for (int i = 0; i < values.length; i++) {
                String value = values[i].getValue().replaceAll("\\p{Cc}", "");
                values[i].setValue(value);
            }
            data.setValues(values);
        }
        return data;
    }

    public boolean isRunning() throws IOException, TransIdException, ErrorException {
        RecordingIsRunningResponse response = client.request(
            new RecordingRequest("recording_is_running", new RecordingData(recordingId)),
            RecordingIsRunningResponse.class);
        return response.getData().getRunning();
    }

    public void rename(String name) throws IOException, TransIdException, ErrorException {
        client.request(new RecordingRequest("recording_rename", new RecordingRenameData(recordingId, name)));
    }
}