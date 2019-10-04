package com.qoitech.otii.response;

import com.fasterxml.jackson.annotation.*;

public class TransactionResponse extends ResponseType {
    private String transId = null;
    @JsonGetter("trans_id") public String getTransId() { return this.transId; }
    @JsonSetter("trans_id") public void setTransId(String transId) { this.transId = transId; }
}