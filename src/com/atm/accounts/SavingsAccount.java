package com.atm.accounts;

import com.atm.exceptions.InsufficientFundsException;

// Inheritance from BankAccount
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Polymorphism: Overriding withdraw method
    @Override
    public boolean withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (getBalance() < amount || getBalance() - amount < 500) { // Minimum balance requirement
            throw new InsufficientFundsException("Insufficient funds or below minimum balance");
        }
        setBalance(getBalance() - amount);
        return true;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}