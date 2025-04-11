package com.atm.atm;

public class CashDispenser {
    private double availableCash;

    public CashDispenser(double availableCash) {
        this.availableCash = availableCash;
    }

    public boolean dispenseCash(double amount) {
        if (amount <= availableCash) {
            availableCash -= amount;
            return true;
        }
        return false;
    }
}