package com.khush.meditrack.factory;

import com.khush.meditrack.entity.Bill;

public class BillFactory {
    public static Bill createBill(double amount) {
        return new Bill(amount);
    }
}
