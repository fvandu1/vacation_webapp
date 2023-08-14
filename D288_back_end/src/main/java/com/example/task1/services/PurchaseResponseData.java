package com.example.task1.services;


import lombok.Data;

@Data
public class PurchaseResponseData {

    private String orderTrackingNumber;

    public PurchaseResponseData() {

    }

    public PurchaseResponseData(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
