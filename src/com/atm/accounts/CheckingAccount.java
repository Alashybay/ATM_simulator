package com.atm.accounts;

import com.atm.exceptions.InsufficientFundsException;

// Inheritance from BankAccount
public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Polymorphism: Overriding withdraw method
    @Override
    public boolean withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (getBalance() + overdraftLimit < amount) {
            throw new InsufficientFundsException("Insufficient funds including overdraft");
        }
        setBalance(getBalance() - amount);
        return true;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Account Type: Checking");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}