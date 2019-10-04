package com.qoitech.otii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.fasterxml.jackson.databind.*;
import com.qoitech.otii.response.*;
import com.qoitech.otii.request.*;

public class OtiiClient {
    public static final int NO_TIMEOUT = 0;
    public static final int READ_TIMEOUT_MS = 3000;

    public class TransIdException extends Exception {
        static final long serialVersionUID = 1L;

        TransIdException(String message) {
            super(message);
        }
    }

    public class ErrorException extends Exception {
        static final long serialVersionUID = 1L;

        ErrorException(String message) {
            super(message);
        }
    }

    private Socket socket = null;
    private PrintWriter writer;
    private BufferedReader reader;
    private int transId = 0;

    private ProgressHandler progressHandler = null;
    public void setProgressHandler(ProgressHandler progressHandler) {
        this.progressHandler = progressHandler;
    }

    private InformationHandler informationHandler = null;
    public void setInformationHandler(InformationHandler informationHandler) {
        this.informationHandler = informationHandler;
    }

    public OtiiClient() {
    }

    public boolean connect(String host, int port) {
        try {
            socket = new Socket(host, port);
            socket.setSoTimeout(READ_TIMEOUT_MS);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String version = reader.readLine();
            if (informationHandler != null) {
                InformationResponse informationResponse = (new ObjectMapper()).readValue(version, InformationResponse.class);
                informationHandler.information(informationResponse);
            }
        }
        catch (IOException e) {
            System.out.print("Connection failed: ");
            System.out.println(e.getMessage());
        }
        return socket != null;
    }

    public void disconnect() {
        if (socket != null) {
            try {
                socket.close();
            }
            catch (IOException e) {
                System.out.print("Disconnection failed: ");
                System.out.println(e.getMessage());
            }
        }
    }

    public void request(Request request) throws IOException, TransIdException, ErrorException {
        request(request, Response.class, -1);
    }

    public void request(Request request, int timeout) throws IOException, TransIdException, ErrorException {
        request(request, Response.class, timeout);
    }

    public <T> T request(Request request, Class<T> valueType) throws IOException, TransIdException, ErrorException {
        return request(request, valueType, -1);
    }

    public <T> T request(Request request, Class<T> valueType, int timeout) throws IOException, TransIdException, ErrorException {
        T response = null;

        String transId = String.valueOf(++this.transId);
        request.setTransId(transId);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(request);

        writer.println(jsonRequest);
        writer.flush();

        if (timeout >= 0) {
            socket.setSoTimeout(timeout);
        }

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        while (response == null) {
            String jsonData = reader.readLine();
            TransactionResponse transactionResponse = objectMapper.readValue(jsonData, TransactionResponse.class);
            if (transactionResponse.getType().equals(ResponseType.RESPONSE) || transactionResponse.getType().equals(ResponseType.ERROR)) {
                if (transactionResponse.getTransId().equals(transId)) {
                    if (transactionResponse.getType().equals(ResponseType.RESPONSE)) {
                        response = (new ObjectMapper()).readValue(jsonData, valueType);
                    } else {
                        throw new ErrorException(String.format("Error: %s", jsonData));
                    }
                } else {
                    throw new TransIdException("Unmatched transaction id");
                }
            } else if (transactionResponse.getType().equals(ResponseType.PROGRESS)) {
                ProgressResponse progressResponse = (new ObjectMapper()).readValue(jsonData, ProgressResponse.class);
                if (progressHandler != null) {
                    progressHandler.progress(progressResponse.getProgressValue());
                }
            }
        }

        if (timeout >= 0) {
            socket.setSoTimeout(READ_TIMEOUT_MS);
        }

        return response;
    }

    public Otii otii() {
        return new Otii(this);
    }
}
