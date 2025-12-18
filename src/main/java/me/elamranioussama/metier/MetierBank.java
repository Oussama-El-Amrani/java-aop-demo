package me.elamranioussama.metier;

import me.elamranioussama.models.Account;

import java.util.HashMap;
import java.util.Map;

public class MetierBank implements  IMetierBank {
    private Map<Long, Account> accounts = new HashMap<>();

    @Override
    public void saveAccount(Long code, Account account) {
        accounts.put(code, account);
    }


    @Override
    public Account getAccount(Long code) {
        return accounts.get(code);
    }

    @Override
    public void deposit(Long code, Double amount) {
        Account account = accounts.get(code);
        if (account != null) {
            Double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
        }
    }

    @Override
    public void withdraw(Long code, Double amount) {
        Account account = accounts.get(code);
        if (account != null) {
            Double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }
}
