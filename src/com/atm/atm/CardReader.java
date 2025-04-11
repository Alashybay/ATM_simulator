package com.atm.atm;

import com.atm.accounts.CheckingAccount;
import com.atm.accounts.SavingsAccount;
import com.atm.users.User;

public class CardReader {
    public User validateCard(String userId) {
        // Simulate card validation by returning a predefined user
        if ("user123".equals(userId)) {
            User user = new User("user123", "1234");
            user.addAccount(new SavingsAccount("SA001", 1000, 0.05));
            user.addAccount(new CheckingAccount("CA001", 500, 200));
            return user;
        }
        return null;
    }
}