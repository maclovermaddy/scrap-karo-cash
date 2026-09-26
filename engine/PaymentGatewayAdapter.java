package com.scrapkarocash.app.engine;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewayAdapter {

    private String merchantId;

    public PaymentGatewayAdapter(String merchantId) {
        this.merchantId = merchantId;
    }

    public Map<String, String> initiateVendorPayout(String vendorId, double amount) {
        Map<String, String> response = new HashMap<>();
        response.put("transactionId", "TXN_" + System.currentTimeMillis());
        response.put("vendorId", vendorId);
        response.put("amount", String.valueOf(amount));
        response.put("status", "SUCCESS");
        return response;
    }
}
