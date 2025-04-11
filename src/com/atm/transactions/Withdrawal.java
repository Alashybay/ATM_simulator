package com.atm.transactions;

import com.atm.accounts.BankAccount;

public class Withdrawal extends Transaction {
    public Withdrawal(BankAccount account, double amount) {
        super(account, amount);
    }

    @Override
    public void printDetails() {
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Type: Withdrawal");
        System.out.println("Amount: $" + getAmount());
        System.out.println("Account: " + getAccount().getAccountNumber());
        System.out.println("Timestamp: " + getTimestamp());
    }
}