package com.khush.meditrack.service;

import com.khush.meditrack.entity.Bill;
import com.khush.meditrack.entity.BillSummary;

public class BillingService {

    public BillSummary generateSummary(Bill bill) {
        return new BillSummary(bill.calculateTotal());
    }
}
