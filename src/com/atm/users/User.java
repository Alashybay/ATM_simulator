package com.atm.users;

import com.atm.accounts.BankAccount;
import com.atm.interfaces.Authenticatable;

import java.util.ArrayList;
import java.util.List;

// Composition: User owns multiple BankAccounts
public class User implements Authenticatable {
    private String userId;
    private String pin; // Encapsulation
    private List<BankAccount> accounts;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }
}