package com.qoitech.otii;

import com.fasterxml.jackson.annotation.*;

public class Supply {
    private int supplyId = 0;
    @JsonGetter("supply_id") public int getSupplyId() { return this.supplyId; }
    @JsonSetter("supply_id") public void setSupplyId(int supplyId) { this.supplyId = supplyId; }

    private String name = null;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private String manufacturer = null;
    public String getManufacturer() { return this.manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    private String model = null;
    public String getModel() { return this.model; }
    public void setModel(String model) { this.model = model; }
}