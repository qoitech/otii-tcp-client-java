package com.qoitech.otii.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ArcGetSupplyData {
    private int supplyId = 0;
    @JsonGetter("supply_id") public int getSupplyId() { return this.supplyId; }
    @JsonSetter("supply_id") public void setSupplyId(int supplyId) { this.supplyId = supplyId; }
}