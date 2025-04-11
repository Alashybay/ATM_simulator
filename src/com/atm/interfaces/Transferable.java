package com.atm.interfaces;

import com.atm.accounts.BankAccount;

public interface Transferable {
    BankAccount getToAccount();
}