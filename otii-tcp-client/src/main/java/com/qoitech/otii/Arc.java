package com.qoitech.otii;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;
import com.qoitech.otii.OtiiClient.ErrorException;
import com.qoitech.otii.OtiiClient.TransIdException;
import com.qoitech.otii.request.*;
import com.qoitech.otii.response.*;

public class Arc {
    private static final int CALIBRATION_TIMEOUT = 8000;

    private OtiiClient client = null;
    public void setOtiiClient(OtiiClient client) { this.client = client; }

    private String deviceId = null;
    @JsonGetter("device_id") public String getDeviceId() { return this.deviceId; }
    @JsonSetter("device_id") public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    private String name = null;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private String type = null;
    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }

    public void calibrate() throws IOException, TransIdException, ErrorException {
        int timeout = OtiiClient.READ_TIMEOUT_MS + CALIBRATION_TIMEOUT;
        client.request(new ArcRequest("arc_calibrate", new ArcData(deviceId)), timeout);
    }

    public void enable5v(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_enable_5v", new ArcEnable5vData(deviceId, enable)));
    }

    public void enableChannel(String channel, boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_enable_channel", new ArcEnableChannelData(deviceId, channel, enable)));
    }

    public void enableExpPort(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_enable_exp_port", new ArcEnableExpPortData(deviceId, enable)));
    }

    public void enableUart(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_enable_uart", new ArcEnableUartData(deviceId, enable)));
    }

    public double getAdcResistor() throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_adc_resistor", new ArcData(deviceId)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public double getExpVoltage() throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_exp_voltage", new ArcData(deviceId)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public boolean getGpi(int pin) throws IOException, TransIdException, ErrorException {
        ArcBooleanValueResponse response = client.request(
            new ArcRequest("arc_get_gpi", new ArcGetGpiData(deviceId, pin)), ArcBooleanValueResponse.class);
        return response.getData().getValue();
    }

    public double getMainVoltage() throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_main_voltage", new ArcData(deviceId)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public double getMaxCurrent() throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_max_current", new ArcData(deviceId)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public String getRange() throws IOException, TransIdException, ErrorException {
        ArcGetRangeResponse response = client.request(
            new ArcRequest("arc_get_range", new ArcData(deviceId)), ArcGetRangeResponse.class);
        return response.getData().getRange();
    }

    public boolean getRx() throws IOException, TransIdException, ErrorException {
        ArcBooleanValueResponse response = client.request(
            new ArcRequest("arc_get_rx", new ArcData(deviceId)), ArcBooleanValueResponse.class);
        return response.getData().getValue();
    }

    public Supply[] getSupplies() throws IOException, TransIdException, ErrorException {
        ArcGetSuppliesResponse response = client.request(
            new ArcRequest("arc_get_supplies", new ArcData(deviceId)), ArcGetSuppliesResponse.class);
        return response.getData().getSupplies();
    }

    public int getSupply() throws IOException, TransIdException, ErrorException {
        ArcGetSupplyResponse response = client.request(
            new ArcRequest("arc_get_supply", new ArcData(deviceId)),
            ArcGetSupplyResponse.class);
        return response.getData().getSupplyId();
    }

    public int getSupplyParallel() throws IOException, TransIdException, ErrorException {
        ArcIntValueResponse response = client.request(
            new ArcRequest("arc_get_supply_parallel", new ArcData(deviceId)),
            ArcIntValueResponse.class);
        return response.getData().getValue();
    }

    public int getSupplySeries() throws IOException, TransIdException, ErrorException {
        ArcIntValueResponse response = client.request(
            new ArcRequest("arc_get_supply_series", new ArcData(deviceId)),
            ArcIntValueResponse.class);
        return response.getData().getValue();
    }

    public boolean getSupplySocTracking() throws IOException, TransIdException, ErrorException {
        ArcGetSupplySocTrackingResponse response = client.request(
            new ArcRequest("arc_get_supply_soc_tracking", new ArcData(deviceId)),
            ArcGetSupplySocTrackingResponse.class);
        return response.getData().getEnabled();
    }

    public double getSupplyUsedCapacity() throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_supply_used_capacity", new ArcData(deviceId)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public int getUartBaudrate() throws IOException, TransIdException, ErrorException {
        ArcGetUartBaudrateResponse response = client.request(
            new ArcRequest("arc_get_uart_baudrate", new ArcData(deviceId)), ArcGetUartBaudrateResponse.class);
        return response.getData().getValue();
    }

    public double getValue(String channel) throws IOException, TransIdException, ErrorException {
        ArcDoubleValueResponse response = client.request(
            new ArcRequest("arc_get_value", new ArcGetValueData(deviceId, channel)), ArcDoubleValueResponse.class);
        return response.getData().getValue();
    }

    public VersionData getVersion() throws IOException, TransIdException, ErrorException {
        ArcGetVersionResponse response = client.request(
            new ArcRequest("arc_get_version", new ArcData(deviceId)), ArcGetVersionResponse.class);
        return response.getData();
    }

    public boolean isConnected() throws IOException, TransIdException, ErrorException {
        ArcIsConnectedResponse response = client.request(
            new ArcRequest("arc_is_connected", new ArcData(deviceId)), ArcIsConnectedResponse.class);
        return response.getData().getConnected();
    }

    public void setAdcResistor(double value) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_adc_resistor", new ArcSetAdcResistorData(deviceId, value)));
    }

    public void setExpVoltage(double voltage) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_exp_voltage", new ArcSetExpVoltageData(deviceId, voltage)));
    }

    public void setGpo(int pin, boolean value) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_gpo", new ArcSetGpoData(deviceId, pin, value)));
    }

    public void setMain(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_main", new ArcSetMainData(deviceId, enable)));
    }

    public void setMainVoltage(double voltage) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_main_voltage", new ArcSetMainVoltageData(deviceId, voltage)));
    }

    public void setMaxCurrent(double current) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_max_current", new ArcSetMaxCurrentData(deviceId, current)));
    }

    public void setRange(String range) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_range", new ArcSetRangeData(deviceId, range)));
    }

    public void setSupply(int supplyId) throws IOException, TransIdException, ErrorException {
        setSupply(supplyId, 1, 1);
    }

    public void setSupply(int supplyId, int series, int parallel) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_supply", new ArcSetSupplyData(deviceId, supplyId, series, parallel)));
    }

    public void setSupplySocTracking(boolean enable) throws IOException, TransIdException, ErrorException {
        client.request(
            new ArcRequest("arc_set_supply_soc_tracking", new ArcSetSupplySocTrackingData(deviceId, enable)));
    }

    public void setSupplyUsedCapacity(double value) throws IOException, TransIdException, ErrorException {
        client.request(
            new ArcRequest("arc_set_supply_used_capacity", new ArcSetSupplyUsedCapacityData(deviceId, value)));
    }

    public void setTx(boolean value) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_tx", new ArcSetTxData(deviceId, value)));
    }

    public void setUartBaudrate(int baudrate) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_set_uart_baudrate", new ArcSetUartBaudrateData(deviceId, baudrate)));
    }

    public void writeTxData(String value) throws IOException, TransIdException, ErrorException {
        client.request(new ArcRequest("arc_write_tx", new ArcWriteTxData(deviceId, value)));
    }
}