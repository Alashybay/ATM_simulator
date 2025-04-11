package com.atm.transactions;

import com.atm.accounts.BankAccount;
import com.atm.interfaces.Transferable;

public class Transfer extends Transaction implements Transferable {
    private BankAccount toAccount;

    public Transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        super(fromAccount, amount);
        this.toAccount = toAccount;
    }

    @Override
    public BankAccount getToAccount() {
        return toAccount;
    }

    @Override
    public void printDetails() {
        System.out.println("Transaction ID: " + getTransactionId());
        System.out.println("Type: Transfer");
        System.out.println("Amount: $" + getAmount());
        System.out.println("From Account: " + getAccount().getAccountNumber());
        System.out.println("To Account: " + toAccount.getAccountNumber());
        System.out.println("Timestamp: " + getTimestamp());
    }
}