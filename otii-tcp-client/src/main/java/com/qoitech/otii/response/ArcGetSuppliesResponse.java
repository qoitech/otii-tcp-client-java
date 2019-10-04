package com.qoitech.otii.response;

import com.qoitech.otii.*;

public class ArcGetSuppliesResponse extends Response {
    public class ArcGetSuppliesData {
        private Supply[] supplies = null;
        public Supply[] getSupplies() { return this.supplies; }
        public void setSupplies(Supply[] supplies) { this.supplies = supplies; }
    }

    private ArcGetSuppliesData data = null;
    public ArcGetSuppliesData getData() { return this.data; }
    public void setData(ArcGetSuppliesData data) { this.data = data; }
}