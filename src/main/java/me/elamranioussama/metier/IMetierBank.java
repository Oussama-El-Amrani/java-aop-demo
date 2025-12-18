package me.elamranioussama.metier;

import me.elamranioussama.models.Account;

public interface IMetierBank {
    void saveAccount(Long code, Account account);
    Account getAccount(Long code);
    void deposit(Long code, Double amount);
    void withdraw(Long code, Double amount);
}
