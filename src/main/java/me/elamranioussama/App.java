package me.elamranioussama;

import me.elamranioussama.metier.MetierBank;
import me.elamranioussama.models.Account;

public class App {
    public static void main(String[] args) { MetierBank bank = new MetierBank();

        Account acc1 = new Account(1L, 100.0);
        Account acc2 = new Account(2L, 50.0);

        bank.saveAccount(1L, acc1);
        bank.saveAccount(2L, acc2);

        bank.deposit(1L, 25.0);
        bank.withdraw(2L, 10.0);

        System.out.println("Account 1 balance = " + bank.getAccount(1L).getBalance());
        System.out.println("Account 2 balance = " + bank.getAccount(2L).getBalance());
    }
}
