package com.atm.transactions;

import com.atm.accounts.BankAccount;

public class Deposit extends Transaction {
    public Deposit(BankAccount account, double amount) {
        super(account, amount);
    }

    @Override
    public void printDetails() {
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Type: Deposit");
        System.out.println("Amount: $" + getAmount());
        System.out.println("Account: " + getAccount().getAccountNumber());
        System.out.println("Timestamp: " + getTimestamp());
    }
}