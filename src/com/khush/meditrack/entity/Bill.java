package com.khush.meditrack.entity;

import com.khush.meditrack.interfaces.Payable;
import com.khush.meditrack.constants.Constants;

public class Bill implements Payable {

    private final double amount;

    public Bill(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateTotal() {
        return amount + (amount * Constants.TAX_RATE);
    }
}
