package com.atm.transactions;

import com.atm.accounts.BankAccount;
import com.atm.interfaces.Printable;

import java.time.LocalDateTime;

// Abstract class for transactions
public abstract class Transaction implements Printable {
    private String transactionId;
    private BankAccount account;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(BankAccount account, double amount) {
        this.transactionId = "TX" + System.currentTimeMillis();
        this.account = account;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public BankAccount getAccount() {
        return account;
    }
}