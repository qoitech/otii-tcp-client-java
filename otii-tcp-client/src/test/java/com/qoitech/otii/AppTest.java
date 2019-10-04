package com.qoitech.otii;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qoitech.otii.data.*;
import com.qoitech.otii.OtiiClient.ErrorException;
import com.qoitech.otii.OtiiClient.TransIdException;

class AppTest {
    private static final int RECORDING_TIME_IN_SECONDS = 1;

    static final class Settings {
        static final String HOST = "localhost";
        static final int PORT = 1905;
        static final int RECORDING_TIME_IN_SECONDS = 3;
    }
    static OtiiClient client = null;
    static Otii otii = null;

    @BeforeAll
    static void beforeAll() {
        client = new OtiiClient();
        client.connect(Settings.HOST, Settings.PORT);
        otii = client.otii();
    }

    @AfterAll
    static void afterAll() {
        client.disconnect();
        otii = null;
        client = null;
    }

    @Test
    void shouldCreateProject() {
        try {
            // Remove any open project
            Project project = otii.getActiveProject();
            if (project != null) {
                project.close(true);
                project = null;
            }
            assertNull(project);

            Arc[] arcs = otii.getDevices();
            assertEquals(1, arcs.length);
            Arc arc = arcs[0];

            arc.setMainVoltage(3.0);
            arc.setExpVoltage(3.0);
            arc.setMaxCurrent(0.5);
            arc.setUartBaudrate(115200);
            arc.enableUart(true);
            arc.enableExpPort(true);

            arc.enableChannel("mc", true);
            arc.enableChannel("me", true);
            arc.enableChannel("i1", true);
            arc.enableChannel("rx", true);

            project = otii.createProject();
            assertNotNull(project);

            otii.setAllMain(true);
            project.startRecording();
            TimeUnit.SECONDS.sleep(Settings.RECORDING_TIME_IN_SECONDS);
            project.stopRecording();
            otii.setAllMain(false);

            Recording recording = project.getLastRecording();
            int count = recording.getChannelDataCount(arc.getDeviceId(), "rx");
            assertTrue(count > 0);
        }
        catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    void featureTest() {
        try {
            Arc[] devices = otii.getDevices();
            if (devices.length == 0) {
                System.out.println("No available devices");
                return;
            }
            Arc arc = devices[0];

            Project project = otii.getActiveProject();
            if (project == null) {
                project = otii.openProject("Testar.otii", false, (progressValue) -> { System.out.print(progressValue); });
            }
            if (project == null) {
                project = otii.createProject();
            }

            System.out.printf("ADC resistor = %f\n", arc.getAdcResistor());
            System.out.printf("Exp voltage = %f\n", arc.getExpVoltage());
            System.out.printf("GPI 1 is %s\n", arc.getGpi(1) ? "on" : "off");
            System.out.printf("GPI 2 is %s\n", arc.getGpi(2) ? "on" : "off");
            System.out.printf("Main voltage = %f\n", arc.getMainVoltage());
            System.out.printf("Max current = %f\n", arc.getMaxCurrent());
            System.out.printf("Range = %s\n", arc.getRange());
            System.out.printf("RX is %s\n", arc.getRx() ? "on" : "off");
            System.out.printf("Supply id = %d\n", arc.getSupply());
            for (Supply supply : arc.getSupplies()) {
                System.out.printf("Supply id: %d, name = %s", supply.getSupplyId(), supply.getName());
                if (supply.getManufacturer() != null) {
                    System.out.printf(", manufacturer = %s", supply.getManufacturer());
                }
                if (supply.getModel() != null) {
                    System.out.printf(", model = %s", supply.getModel());
                }
                System.out.println();
            }
            System.out.printf("Supply SOC tracking is %s\n", arc.getSupplySocTracking() ? "on" : "off");
            System.out.printf("Supply used capacity = %f\n", arc.getSupplyUsedCapacity());
            System.out.printf("UART baudrate = %d\n", arc.getUartBaudrate());
            System.out.printf("VBUS value = %f\n", arc.getValue("vb"));
            VersionData version = arc.getVersion();
            System.out.printf("HW version = %s\n", version.getHwVersion());
            System.out.printf("FW version = %s\n", version.getFwVersion());
            System.out.printf("Arc is %s\n", arc.isConnected() ? "connected" : "not connected");

            arc.setSupply(0, 1, 1);
            arc.setSupplySocTracking(true);
            arc.setSupplyUsedCapacity(0.5);
            arc.setRange("low");
            arc.setMainVoltage(3.3);
            arc.setExpVoltage(3.3);
            arc.setMaxCurrent(0.5);
            arc.setAdcResistor(0.1);
            arc.setUartBaudrate(115200);
            arc.enableUart(true);
            arc.enableExpPort(true);
            arc.enable5v(true);

            arc.setGpo(1, true);
            arc.setTx(true);
            arc.writeTxData("Testar\n");

            System.out.println("Calibrating...");
            arc.calibrate();
            System.out.println("Calibrated!");

            arc.enableChannel("mc", true);
            arc.enableChannel("me", true);
            arc.enableChannel("i1", true);
            arc.enableChannel("rx", true);

            project.startRecording();

            otii.setAllMain(true);
            TimeUnit.SECONDS.sleep(RECORDING_TIME_IN_SECONDS);
            otii.setAllMain(false);

            Recording lastRecording = project.getLastRecording();
            System.out.printf("Recording is %s\n", lastRecording.isRunning() ? "running" : "not running");

            project.stopRecording();

            System.out.printf("Recording is %s\n", lastRecording.isRunning() ? "running" : "not running");

            Date date = new Date();
            lastRecording.rename(date.toString());

            Recording[] recordings = project.getRecordings();
            for (Recording recording : recordings) {
                System.out.println(recording.getName());
            }
            if (recordings.length > 2) {
                recordings[recordings.length - 1].delete();
            }

            int count = lastRecording.getChannelDataCount(arc.getDeviceId(), "me");
            System.out.printf("Count me = %d\n", count);
            AnalogData analogData = lastRecording.getAnalogChannelData(arc.getDeviceId(), "me", count - 1, 1);
            double energy = analogData.getValues()[0];
            System.out.printf("Energy = %f J\n", energy);
            double consumed = analogData.getValues()[0] / 3.6;
            System.out.printf("Energy = %f mWh\n", consumed);

            count = lastRecording.getChannelDataCount(arc.getDeviceId(), "i1");
            System.out.printf("Count i1 = %d\n", count);
            if (count > 0) {
                DigitalData digitalData = lastRecording.getDigitalChannelData(arc.getDeviceId(), "i1", 0, count);
                System.out.printf("%s\n", digitalData.getValues()[0].getValue() ? "on" : "off");

                double timestamp = digitalData.getValues()[0].getTimestamp();
                int index = lastRecording.getChannelDataIndex(arc.getDeviceId(), "mc", timestamp);
                System.out.printf("Index = %d\n", index);
            }

            count = lastRecording.getChannelDataCount(arc.getDeviceId(), "rx");
            System.out.printf("Count rx = %d\n", count);
            if (count > 0) {
                LogData logData = lastRecording.getLogChannelData(arc.getDeviceId(), "rx", 0, count);
                System.out.printf("%s\n", logData.getValues()[0].getValue());
            }

            project.save("Testing.otii", true, (progressValue) -> { System.out.print(progressValue); });

            /*
            TimeUnit.SECONDS.sleep(3);
            project.cropData(1.5, 2.5);
            */

//            project.close(true);
        }
        catch (IOException | InterruptedException | TransIdException | ErrorException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldAnswerWithFalse() {
        assertFalse(false);
    }
}