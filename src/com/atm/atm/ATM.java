package com.atm.atm;

import com.atm.accounts.BankAccount;
import com.atm.exceptions.AccountNotFoundException;
import com.atm.exceptions.InsufficientFundsException;
import com.atm.exceptions.InvalidPinException;
import com.atm.transactions.Deposit;
import com.atm.transactions.Transaction;
import com.atm.transactions.Transfer;
import com.atm.transactions.Withdrawal;
import com.atm.users.User;

// Composition: ATM contains CardReader, CashDispenser, Display
public class ATM {
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Display display;
    private User currentUser;

    public ATM() {
        this.cardReader = new CardReader();
        this.cashDispenser = new CashDispenser(10000); // Initial cash
        this.display = new Display();
    }

    public void start() {
        display.showMessage("Welcome to the ATM");
    }

    public boolean authenticateUser(String userId, String pin) throws InvalidPinException {
        currentUser = cardReader.validateCard(userId);
        if (currentUser == null || !currentUser.authenticate(pin)) {
            throw new InvalidPinException("Invalid user ID or PIN");
        }
        display.showMessage("Authentication successful");
        return true;
    }

    public void displayAccounts() {
        display.showMessage("Your Accounts:");
        for (BankAccount account : currentUser.getAccounts()) {
            account.printDetails();
        }
    }

    public void deposit(String accountNumber, double amount) throws Exception {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        account.deposit(amount);
        Transaction deposit = new Deposit(account, amount);
        account.addTransaction(deposit);
        display.showMessage("Deposited $" + amount + " to account " + accountNumber);
    }

    public void withdraw(String accountNumber, double amount) throws Exception {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        if (cashDispenser.dispenseCash(amount)) {
            if (account.withdraw(amount)) {
                Transaction withdrawal = new Withdrawal(account, amount);
                account.addTransaction(withdrawal);
                display.showMessage("Withdrawn $" + amount + " from account " + accountNumber);
            }
        } else {
            throw new InsufficientFundsException("ATM has insufficient cash");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws Exception {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        if (fromAccount == null || toAccount == null) {
            throw new AccountNotFoundException("One or both accounts not found");
        }
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            Transaction transfer = new Transfer(fromAccount, toAccount, amount);
            fromAccount.addTransaction(transfer);
            toAccount.addTransaction(transfer);
            display.showMessage("Transferred $" + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
        }
    }

    public void checkBalance(String accountNumber) throws AccountNotFoundException {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        account.printDetails();
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : currentUser.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}