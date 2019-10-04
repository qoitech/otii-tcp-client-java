package com.qoitech.otii.request;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ArcSetSupplyData extends ArcData {
    private int supplyId = 0;
    @JsonGetter("supply_id") int getSupplyId() { return this.supplyId; }
    private int series = 0;
    @JsonGetter("series") int getSeries() { return this.series; }
    private int parallel = 0;
    @JsonGetter("parallel") int getParallel() { return this.parallel; }

    public ArcSetSupplyData(String deviceId, int supplyId, int series, int parallel) {
        super(deviceId);
        this.supplyId = supplyId;
        this.series = series;
        this.parallel = parallel;
    }
}