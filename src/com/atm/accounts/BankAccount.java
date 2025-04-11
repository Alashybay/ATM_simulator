package com.atm.accounts;

import com.atm.interfaces.Printable;
import com.atm.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

// Abstract class demonstrating abstraction
public abstract class BankAccount implements Printable {
    private String accountNumber; // Encapsulation
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Abstract methods for polymorphism
    public abstract boolean withdraw(double amount) throws Exception;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}